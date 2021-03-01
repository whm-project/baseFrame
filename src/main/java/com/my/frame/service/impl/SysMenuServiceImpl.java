package com.my.frame.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.base.BaseServiceImpl;
import com.my.base.SearchTypeEnum;
import com.my.frame.dao.SysMenuDao;
import com.my.frame.model.SysMenu;
import com.my.commonEnum.IsParentEnum;
import com.my.frame.model.querymodel.SysMenuQueryModel;
import com.my.frame.service.SysMenuService;
import com.my.utils.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
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
@Service
@Transactional(rollbackFor = Exception.class)
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements SysMenuService {

    @Resource
    private SysMenuDao sysMenuMapper;

    /**
     * 根据查询条件，查询菜单集合【不分页】
     * @param sysMenuQueryModel
     * @return
     */
    @Override
    public List<SysMenu> getMenuByQuery(SysMenuQueryModel sysMenuQueryModel) {
        Example example = new Example(SysMenu.class);
        Example.Criteria criteria = example.createCriteria();
        //父级
        String supMenuCd = sysMenuQueryModel.getSupMenuCd();
        if(null != supMenuCd && "" != supMenuCd){
            criteria.andEqualTo("supMenuCd", supMenuCd);
        }
        //url
        String menuUrl = sysMenuQueryModel.getMenuUrl();
        if(null != menuUrl && "" != menuUrl){
            criteria.andEqualTo("menuUrl", menuUrl);
        }

        return sysMenuMapper.selectByExample(example);
    }

    /**
     * 根据查询条件，查询菜单集合
     * @param sysMenuQueryModel
     * @return
     */
    @Override
    public PageInfo<SysMenu> getMenuPageByQuery(SysMenuQueryModel sysMenuQueryModel) {
        Example example = new Example(SysMenu.class);
        Example.Criteria criteria = example.createCriteria();
        //父级
        String supMenuCd = sysMenuQueryModel.getSupMenuCd();
        if(null != supMenuCd && "" != supMenuCd){
            criteria.andEqualTo("supMenuCd", supMenuCd);
        }
        //排序
        example.orderBy("menuOrder");
        //查询
        PageHelper.startPage(sysMenuQueryModel.getPageNumber(), sysMenuQueryModel.getPageSize());
        List<SysMenu> menuList = sysMenuMapper.selectByExample(example);
        return new PageInfo<SysMenu>(menuList);
    }

    /**
     * 设置菜单是否是父节点
     * @param menu_cd
     */
    @Override
    public short setMenuIsParent(String menu_cd) {
        short result;

        //查询结果
        List<SysMenu> childMenuList = findInfo("supMenuCd", menu_cd, SearchTypeEnum.EQ.getValue(), "menuOrder", SysMenu.class);

        SysMenu menu = new SysMenu();
        //设置是否有子节点
        if(childMenuList.size() > 0){
            menu.setMenuIsparent(IsParentEnum.HASCHILD.getValue());
            result = IsParentEnum.HASCHILD.getValue();
        }else{
            menu.setMenuIsparent(IsParentEnum.NOCHILD.getValue());
            result = IsParentEnum.NOCHILD.getValue();
        }
        updateInfoSelective(menu, "menuCd", menu_cd, SearchTypeEnum.EQ.getValue(), SysMenu.class);

        return result;
    }

    /**
     * 更新节点cd，子节点的index需要一起修改【只修改下级，不改自己】
     * @param old_cd
     * @param new_cd
     * @param menuId        自己节点的id，为了不改自己
     */
    @Override
    public void updateCd(String old_cd, String new_cd, Long menuId) {
        //查询原cd下的子节点
        List<SysMenu> childList = findInfo("menuIndex", "%"+old_cd+"%", SearchTypeEnum.LIKE.getValue(), "menuOrder", SysMenu.class);
        //循环子节点
        for(SysMenu child : childList){
            //如果是自己，不用修改
            if(child.getMenuId().equals(menuId)){
                continue;
            }
            //如果该子节点是直接子节点
            if(child.getSupMenuCd().equals(old_cd)){
                //设置父节点是新cd
                child.setSupMenuCd(new_cd);
            }
            //设置子节点的索引
            child.setMenuIndex(child.getMenuIndex().replace(old_cd, new_cd));
            //更新
            updateByPrimaryKeySelective(child);
        }
    }

    /**
     * 修改上级节点cd，两个相关的上级节点的是否是父级节点需要一起修改【只修改下级，不改自己】
     * @param old_sup_cd
     * @param new_sup_cd
     * @param cd
     * @param menuId        自己节点的id，为了不改自己
     */
    @Override
    public void updateSupCd(String old_sup_cd, String new_sup_cd, String cd, Long menuId) {
        String old_eng_man_index = getByUniqueKey("menuCd", old_sup_cd, SysMenu.class).getMenuIndex();
        String new_eng_man_index = getByUniqueKey("menuCd", new_sup_cd, SysMenu.class).getMenuIndex();

        //查询原cd下的子节点
        List<SysMenu> childList = findInfo("menuIndex", "%"+cd+"%", SearchTypeEnum.LIKE.getValue(), "menuOrder", SysMenu.class);
        //循环子节点
        for(SysMenu child : childList){
            //如果是自己，不用修改
            if(child.getMenuId().equals(menuId)){
                continue;
            }
            //设置子节点的索引
            child.setMenuIndex(child.getMenuIndex().replace(old_eng_man_index, new_eng_man_index));
            //更新
            updateByPrimaryKeySelective(child);
        }

        //更新上级是否还有子节点
        setMenuIsParent(old_sup_cd);
        setMenuIsParent(new_sup_cd);
    }


    /**
     * 修改菜单，会判断是否修改上级菜单cd，是否修改了本级菜单cd
     * @param menu
     * @return  {newSupMenuCd: xxxx, oldSupMenuCd:xxxx}
     */
    @Override
    public Map<String, Object> updateSysMenu(SysMenu menu) {
        Long menuId = menu.getMenuId();

        //原节点信息
        SysMenu old_menu = getByPrimaryKey(menu.getMenuId());
        //原节点cd
        String old_menuCd = old_menu.getMenuCd();
        //原上级节点
        String old_sup_menu_cd = old_menu.getSupMenuCd();

        //更新节点信息
        updateByPrimaryKeySelective(menu);

        //新节点编码
        String new_menuCd = menu.getMenuCd();
        //新上级节点
        String new_sup_menu_cd = StringUtil.notNull(menu.getSupMenuCd());

        //如果两个cd不相同，该节点下子节点的上级菜单和菜单索引需要进行修改
        if(!old_menuCd.equals(new_menuCd)){
            updateCd(old_menuCd, new_menuCd, menuId);
        }

        //如果上级节点变了，需要设置新旧两个上级节点的是否还有子节点属性，并且修改当前节点下级节点的索引
        if(!old_sup_menu_cd.equals(new_sup_menu_cd)){
            updateSupCd(old_sup_menu_cd, new_sup_menu_cd, new_menuCd, menuId);
        }

        Map resultMap = new HashMap<String, Object>();
        resultMap.put("newSupMenuCd", new_sup_menu_cd);
        resultMap.put("oldSupMenuCd", old_sup_menu_cd);
        return resultMap;
    }
}
