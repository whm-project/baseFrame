package com.my.frame.controller;

import com.github.pagehelper.PageInfo;
import com.my.base.ListViewModel;
import com.my.base.ResultViewModel;
import com.my.base.SearchTypeEnum;
import com.my.frame.model.SysMenu;
import com.my.frame.model.SysRolemenu;
import com.my.frame.model.SysUsermenu;
import com.my.frame.model.querymodel.SysMenuQueryModel;
import com.my.frame.model.querymodel.SysUsermenuQueryModel;
import com.my.frame.service.SysMenuService;
import com.my.frame.service.SysRolemenuService;
import com.my.frame.service.SysUsermenuService;
import com.my.utils.StringUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 因为菜单要设置链接地址，所以只能程序员管理
 * 因为不会往下分权限，所以只需要根据用户查菜单就可，不用根据当前站点查
 * @author
 * @version 0.0.1
 * @date 2018/07/28
 * @time 14:39
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Controller
@RequestMapping("/sysMenu*")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysUsermenuService sysUsermenuService;
    @Autowired
    private SysRolemenuService sysRolemenuService;

    /**
     * 进入菜单管理页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String show(){
        return "menu/menuManager";
    }

    /**
     * 进入菜单管理页面
     * @return
     */
    @RequestMapping(value = "show_multiple", method = RequestMethod.GET)
    public String show_multiple(){
        return "menu/menuManager_multiple";
    }

    /**
     * 获取子节点
     * @param pcd           上级组织机构
     * @param mtp           菜单类型
     * @param btp           按钮位置
     * @param isBase        基础按钮
     * @param ignore_cd     要忽略的菜单编码
     * @param ignore_type   要忽略的菜单类型（多个的话以逗号分割）
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getChildMenu", method = RequestMethod.POST)
    @ResponseBody
    public List<SysMenu> getChild(
            @RequestParam(value = "pcd", required = false, defaultValue = "") String pcd,
            @RequestParam(value = "mtp", required = false, defaultValue = "") String mtp,
            @RequestParam(value = "btp", required = false, defaultValue = "") String btp,
            @RequestParam(value = "isBaseBtn", required = false, defaultValue = "") String isBase,
            @RequestParam(value = "ignore_cd", required = false, defaultValue = "") String ignore_cd,
            @RequestParam(value = "ignore_type", required = false, defaultValue = "") String ignore_type,
            HttpServletRequest request, HttpServletResponse response
    ){
        List<SysMenu> sysMenuList = new ArrayList<>();

        //如果组织机构选择为空，默认为当前用户所属的组织机构
        if (pcd.equals("")){
            sysMenuList.add(sysMenuService.getByUniqueKey("menuCd", "root", SysMenu.class));
        }
        else {
            //条件集合
            List<String> property = new ArrayList<>();
            List<Object> value = new ArrayList<>();
            List<String> searchType = new ArrayList<>();
            //上级菜单条件
            property.add("supMenuCd");
            value.add(pcd);
            searchType.add(SearchTypeEnum.EQ.getValue());
            //菜单类型条件
            if (!mtp.equals("")) {
                property.add("menuType");
                value.add(mtp);
                searchType.add(SearchTypeEnum.EQ.getValue());
            }
            //是否是基础按钮
            if (!isBase.equals("")) {
                property.add("menuOther4");
                value.add(isBase);
                searchType.add(SearchTypeEnum.EQ.getValue());
            }
            //按钮位置
            if (!btp.equals("")) {
                property.add("btnPosition");
                value.add(btp);
                searchType.add(SearchTypeEnum.EQ.getValue());
            }
            //要忽略的菜单编码
            if (!ignore_cd.equals("")) {
                property.add("menuCd");
                value.add(ignore_cd);
                searchType.add(SearchTypeEnum.NOTLIKE.getValue());
            }
            //要忽略的菜单类型
            if (!ignore_type.equals("")) {
                property.add("menuType");
                value.add(ignore_type);
                searchType.add(SearchTypeEnum.NOTIN.getValue());
            }
            //排序
            String order = " menuOrder asc ";
            //查询
            sysMenuList = sysMenuService.findInfo(property, value, searchType, order, SysMenu.class);
        }

        //返回数据
        return sysMenuList;
    }

    /**
     * 删除菜单
     * @param menuCd    要删除的菜单编码
     * @return
     */
    @RequestMapping(value = "delMenu", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel delMenu(
            @RequestParam(value = "menuCd", required = true) String menuCd
    ){
        //节点信息
        SysMenu menu = sysMenuService.getByUniqueKey("menuCd", menuCd, SysMenu.class);

        //删除节点
        sysMenuService.deleteByProperty("menuIndex", "%"+menuCd+"%", SearchTypeEnum.LIKE.getValue(), SysMenu.class);

        //删除角色和用户相关权限
        sysUsermenuService.deleteByProperty("menuCd", menuCd, SearchTypeEnum.EQ.getValue(), SysUsermenu.class);

        //删除角色和用户相关权限
        sysRolemenuService.deleteByProperty("menuCd", menuCd, SearchTypeEnum.EQ.getValue(), SysRolemenu.class);

        //设置父级菜单的isParent属性
        String sup_menu_cd = menu.getSupMenuCd();
        short isParent = sysMenuService.setMenuIsParent(sup_menu_cd);

        //返回
        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "", isParent);
    }

    /**
     * 验证菜单code唯一性
     * @param menuCd        要验证的组织机构编码
     * @return
     */
    @RequestMapping(value = "checkMenuCd", method = RequestMethod.GET)
    @ResponseBody
    public ResultViewModel checkMenuCd(
            @RequestParam(value = "menuCd", required = true) String menuCd,
            @RequestParam(value = "menuId", required = false, defaultValue = "") String menuId){
        SysMenu menu = sysMenuService.getByUniqueKey("menuCd", menuCd, SysMenu.class);
        //有这个code的记录
        if(menu != null){
            //判断是不是当前记录
            Long menu_id = menu.getMenuId();
            //是当前记录，返回可用
            if(menu_id.equals(menuId)){
                return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "该代码可用！");
            }
            //不是当前记录，返回不可用
            else{
                return new ResultViewModel(ResultViewModel.StateEnum.ABNORMAL.getValue(), "该代码已存在，请检查！");
            }
        }
        //没有这个code的记录，则返回成功
        else{
            return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "该代码可用！");
        }
    }

    /**
     * 增加菜单
     * @param menu      新增的菜单信息
     * @return
     */
    @RequestMapping(value = "createMenu", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel createMenu(
            SysMenu menu, HttpServletRequest request, HttpServletResponse response
    ){
        //保存
        ResultViewModel resultViewModel =  saveMenu(menu);

        //设置添加人拥有权限
        SysUsermenu usermenu = new SysUsermenu();
        usermenu.setUserCd(StringUtil.notNull(request.getSession().getAttribute("userCd")));
        usermenu.setMenuCd(menu.getMenuCd());
        sysUsermenuService.save(usermenu);

        //返回
        return resultViewModel;
    }

    /**
     * 修改菜单
     * @param menu      要修改的菜单信息
     * @return
     */
    @RequestMapping(value = "updateMenu", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel updateMenu(SysMenu menu, HttpServletRequest request, HttpServletResponse response){
        ResultViewModel e = saveMenu(menu);

        //判断修改人是不是有这个权限，没有的话加上
        SysUsermenuQueryModel usermenuQueryModel = new SysUsermenuQueryModel();
        usermenuQueryModel.setUserCd(StringUtil.notNull(request.getSession().getAttribute("userCd")));
        usermenuQueryModel.setMenuCd(menu.getMenuCd());
        List<SysMenu> usermenuList = sysUsermenuService.getUserMenuList(usermenuQueryModel);
        if(usermenuList.size() <=  0){
            SysUsermenu usermenu = new SysUsermenu();
            usermenu.setUserCd(StringUtil.notNull(request.getSession().getAttribute("userCd")));
            usermenu.setMenuCd(menu.getMenuCd());
            sysUsermenuService.save(usermenu);
        }

        return e;
    }

    /**
     * 增改菜单
     * @param menu      菜单信息
     * @return
     */
    private ResultViewModel saveMenu(SysMenu menu){
        String new_sup_menu_cd = StringUtil.notNull(menu.getSupMenuCd());

        //设置索引index
        try {
            SysMenu eng_man = sysMenuService.getByUniqueKey("menuCd", new_sup_menu_cd, SysMenu.class);
            String eng_man_index = StringUtil.notNull(eng_man.getMenuIndex());
            menu.setMenuIndex(eng_man_index+"_"+menu.getMenuCd());
        }catch (Exception e){
            e.printStackTrace();
        }

        //更新或修改
        if(menu.getMenuId() != null){
            Map<String, Object> resultMap = sysMenuService.updateSysMenu(menu);

            //返回原父节点cd和新父节点cd
            return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "", resultMap);
        }else{
            //保存节点信息
            sysMenuService.save(menu);

            //设置父级是否有子节点
            sysMenuService.setMenuIsParent(new_sup_menu_cd);

            //返回新节点信息
            return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "", JSONObject.fromObject(menu).toString());
        }
    }

    /**
     * 根据条件获取菜单集合
     * @param sysMenuQueryModel
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "menuList", method = RequestMethod.GET)
    @ResponseBody
    public ListViewModel<SysMenu> getMenuList(
            SysMenuQueryModel sysMenuQueryModel,
            HttpServletRequest request, HttpServletResponse response
    ){
        //当前用户
        String userCd = StringUtil.notNull(request.getSession().getAttribute("userCd"));
        //获取用户能管理的菜单
        PageInfo<SysMenu> menuPageInfo = sysMenuService.getMenuPageByQuery(sysMenuQueryModel);

        //返回
        return new ListViewModel(ListViewModel.CodeEnum.NORMAL.getValue(), menuPageInfo.getTotal(), menuPageInfo.getList());
    }

}
