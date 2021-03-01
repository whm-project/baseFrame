package com.my.frame.controller;

import com.github.pagehelper.PageInfo;
import com.my.base.ListViewModel;
import com.my.base.ResultViewModel;
import com.my.base.SearchTypeEnum;
import com.my.frame.model.SysRole;
import com.my.frame.model.SysRolemenu;
import com.my.frame.model.querymodel.SysRoleQueryModel;
import com.my.frame.service.SysOrgService;
import com.my.frame.service.SysRoleService;
import com.my.frame.service.SysRolemenuService;
import com.my.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * @author
 * @version 0.0.1
 * @date 2018/07/31
 * @time 15:12
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Controller
@RequestMapping("/sysRole*")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysOrgService sysOrgService;
    @Autowired
    private SysRolemenuService sysRolemenuService;

    @RequestMapping(method = RequestMethod.GET)
    public String show(){
        return "role/roleManager";
    }

    @RequestMapping(method = RequestMethod.GET, value = "select")
    public String show_select(){
        return "role/roleManager_multiple";
    }

    /**
     * 角色分页记录
     * @param roleQueryModel
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "pageRole")
    @ResponseBody
    public ListViewModel<SysRole> getPageRole(
            SysRoleQueryModel roleQueryModel,
            HttpServletRequest request
    ){
        //条件集合
        List<String> property = new ArrayList<>();
        List<Object> value = new ArrayList<>();
        List<String> searchType = new ArrayList<>();

        //设置条件
        property.add("orgCd");
        value.add(request.getAttribute("prefix_orgCd"));
        searchType.add(SearchTypeEnum.EQ.getValue());
        if(roleQueryModel.getRoleNm() != null && !roleQueryModel.getRoleNm().equals("")){
            property.add("roleNm");
            value.add(roleQueryModel.getRoleNm());
            searchType.add(SearchTypeEnum.LIKE.getValue());
        }
        if(roleQueryModel.getRoleCd() != null && !roleQueryModel.getRoleCd().equals("")){
            property.add("roleCd");
            value.add(roleQueryModel.getRoleCd());
            searchType.add(SearchTypeEnum.LIKE.getValue());
        }

        //进行查询
        PageInfo<SysRole> rolePageInfo = sysRoleService.findPageInfo(property, value, searchType, roleQueryModel.getOrder(), SysRole.class, roleQueryModel.getPageNumber(), roleQueryModel.getPageSize());

        //返回结果
        return new ListViewModel(ListViewModel.CodeEnum.NORMAL.getValue(), rolePageInfo.getTotal(), rolePageInfo.getList());
    }

    /**
     * 角色信息
     * @param roleId
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "getRole")
    @ResponseBody
    public ResultViewModel getRole(
            @RequestParam(value = "roleId", required = true) String roleId,
            HttpServletRequest request
    ){
        String prefix_orgCd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));
        SysRole role = sysRoleService.getByUniqueKey("roleId", roleId, SysRole.class);

        if(role != null){
            if(role.getOrgCd().equals(prefix_orgCd)){
                //返回结果
                return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "", role);
            }
            else{
                //返回结果
                return new ResultViewModel(ResultViewModel.StateEnum.ABNORMAL.getValue(), "没有管理该角色权限！");
            }
        }
        else{
            //返回结果
            return new ResultViewModel(ResultViewModel.StateEnum.ABNORMAL.getValue(), "没有该角色！");
        }
    }

    /**
     * 验证角色code唯一性
     * @param roleCd             要检查的角色编码
     * @param roleId
     * @return
     */
    @RequestMapping(value = "checkRoleCd", method = RequestMethod.GET)
    @ResponseBody
    public ResultViewModel checkRoleCd(
            @RequestParam(value = "roleCd", required = true) String roleCd,
            @RequestParam(value = "roleId", required = false, defaultValue = "") String roleId){
        SysRole role = sysRoleService.getByUniqueKey("roleCd", roleCd, SysRole.class);
        //有这个code的记录
        if(role != null){
            //判断是不是当前记录
            Long role_id = role.getRoleId();
            //是当前记录，返回可用
            if(role_id.equals(roleId)){
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
     * 增加角色
     * @param sysRole        新增的角色信息
     * @return
     */
    @RequestMapping(value = "createRole", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel createRole(
            SysRole sysRole,
            HttpServletRequest request
    ){
        return saveRole(sysRole, request);
    }

    /**
     * 修改角色
     * @param sysRole        修改的角色信息
     * @return
     */
    @RequestMapping(value = "updateRole", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel updateRole(
            SysRole sysRole,
            HttpServletRequest request
    ){
        return saveRole(sysRole, request);
    }

    /**
     * 增改角色
     * @param sysRole        保存的角色信息
     * @return
     */
    private ResultViewModel saveRole(
            SysRole sysRole,
            HttpServletRequest request
    ){
        String org_cd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));
        sysRole.setOrgCd(org_cd);

        //更新或修改
        if(sysRole.getRoleId() != null){
            sysRoleService.updateByPrimaryKeySelective(sysRole);
        }else{
            //保存节点信息
            sysRoleService.save(sysRole);
        }

        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
    }

    /**
     * 删除角色
     * @param roleId      角色主键
     * @return
     */
    @RequestMapping(value = "deleteRole", method = RequestMethod.GET)
    @ResponseBody
    public ResultViewModel deleteRole(
            @RequestParam(value = "roleId", required = true) String roleId
    ){
        try{
            //获取删除前信息
            SysRole role = sysRoleService.getByPrimaryKey(roleId);

            if(role != null){
                //删除角色
                sysRoleService.deleteByPrimaryKey(roleId);

                //删除角色权限
                sysRolemenuService.deleteByProperty("roleCd", role.getRoleCd(), SearchTypeEnum.EQ.getValue(), SysRolemenu.class);
            }
            //返回
            return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
        }catch (Exception e){
            e.printStackTrace();
            return new ResultViewModel(ResultViewModel.StateEnum.ABNORMAL.getValue());
        }
    }

}
