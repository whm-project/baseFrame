package com.my.frame.controller;

import com.github.pagehelper.PageInfo;
import com.my.base.ListViewModel;
import com.my.base.ResultViewModel;
import com.my.base.SearchTypeEnum;
import com.my.commonEnum.ModelEnum;
import com.my.commonEnum.OperationEnum;
import com.my.filter.LogAnnotation;
import com.my.frame.model.SysOrg;
import com.my.frame.model.SysUser;
import com.my.frame.model.SysUsermenu;
import com.my.frame.model.querymodel.SysUserQueryModel;
import com.my.frame.model.viewModel.SysUserViewModel;
import com.my.frame.service.SysOrgService;
import com.my.frame.service.SysUserService;
import com.my.frame.service.SysUsermenuService;
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
import java.util.Map;


/**
 * @author
 * @version 0.0.1
 * @date 2018/07/27
 * @time 10:53
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Controller
@RequestMapping("/sysUser*")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysOrgService sysOrgService;
    @Autowired
    private SysUsermenuService sysUsermenuService;

    @RequestMapping(method = RequestMethod.GET)
    public String show(){
        return "user/userManager";
    }

    /**
     * 用户分页记录
     * @param userQueryModel
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "pageUser")
    @ResponseBody
    @LogAnnotation(model = ModelEnum.SYSUSER,operation = OperationEnum.BROWSE)
    public ListViewModel<SysUserViewModel> getPageUser(
            SysUserQueryModel userQueryModel,
            HttpServletRequest request
    ) {
        //如果只看所选组织机构下的用户
        if (userQueryModel.getAll_flag().equals("false")) {
            //如果条件没有组织机构，不用再设置
            if (userQueryModel.getOrgCd() == null || userQueryModel.getOrgCd().equals("")) {
                userQueryModel.setOrgCd(request.getAttribute("prefix_orgCd").toString());
            }
        }
        //查看能管理的所有用户
        else {
            //如果条件没有组织机构，需要设置成当前登录人的组织机构
            if (userQueryModel.getOrgCd() == null || userQueryModel.getOrgCd().equals("")) {
                userQueryModel.setOrgIndex(request.getAttribute("prefix_orgCd").toString());
            }else{
                userQueryModel.setOrgCd("");
                userQueryModel.setOrgIndex(userQueryModel.getOrgCd());
            }
        }

        //进行查询
        PageInfo<SysUserViewModel> userPageInfo = sysUserService.findPageInfo(userQueryModel);

        //返回结果
        return new ListViewModel(ListViewModel.CodeEnum.NORMAL.getValue(), userPageInfo.getTotal(), userPageInfo.getList());
    }

    /**
     * 用户信息
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "getUser")
    @ResponseBody
    public ResultViewModel getUser(
            @RequestParam(value = "userId", required = true) String userId,
            HttpServletRequest request
    ){
        String prefix_orgCd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));
        SysUser user = sysUserService.getByUniqueKey("userId", userId, SysUser.class);

        if(user != null){
            String user_orgIndex = sysOrgService.getByUniqueKey("orgCd", user.getOrgCd(), SysOrg.class).getOrgIndex();
            if(user_orgIndex.contains(prefix_orgCd)){
                //返回结果
                return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "", user);
            }
            else{
                //返回结果
                return new ResultViewModel(ResultViewModel.StateEnum.ABNORMAL.getValue(), "没有管理该用户权限！");
            }
        }
        else{
            //返回结果
            return new ResultViewModel(ResultViewModel.StateEnum.ABNORMAL.getValue(), "没有该用户！");
        }
    }

    /**
     * 验证用户code唯一性
     * @param userCd             要检查的用户编码
     * @param userId
     * @return
     */
    @RequestMapping(value = "checkUserCd", method = RequestMethod.GET)
    @ResponseBody
    public ResultViewModel checkUserCd(
            @RequestParam(value = "userCd", required = true) String userCd,
            @RequestParam(value = "userId", required = false, defaultValue = "") String userId){
        SysUser user = sysUserService.getByUniqueKey("userCd", userCd, SysUser.class);
        //有这个code的记录
        if(user != null){
            //判断是不是当前记录
            Long user_id = user.getUserId();
            //是当前记录，返回可用
            if(user_id.equals(userId)){
                return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "该代码可用！");
            }
            //不是当前记录，返回不可用
            else{
                return new ResultViewModel(ResultViewModel.StateEnum.ABNORMAL.getValue(), "该代码不可用！");
            }
        }
        //没有这个code的记录，则返回成功
        else{
            return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue(), "该代码可用！");
        }
    }

    /**
     * 增加用户
     * @param sysUser        新增的用户信息
     * @return
     */
    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel createUser(
            SysUser sysUser,
            HttpServletRequest request
    ){
        return saveUser(sysUser, request);
    }

    /**
     * 修改用户
     * @param sysUser        修改的用户信息
     * @return
     */
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(propagation=Propagation.REQUIRED, rollbackFor=RuntimeException.class)
    public ResultViewModel updateOrg(
            SysUser sysUser,
            HttpServletRequest request
    ){
        return saveUser(sysUser, request);
    }

    /**
     * 增改用户
     * @param sysUser        保存的用户信息
     * @return
     */
    private ResultViewModel saveUser(
            SysUser sysUser,
            HttpServletRequest request
    ){
        String org_cd = StringUtil.notNull(request.getAttribute("prefix_orgCd"));
        sysUser.setOrgCd(org_cd);

        //更新或修改
        if(sysUser.getUserId() != null){
            sysUserService.updateByPrimaryKeySelective(sysUser);
        }else{
            //初始密码为123456
            Map<String, String> saltPwdMap = sysUserService.setSaltPwd("123456");
            //设置用户盐和密码
            sysUser.setUserSalt(saltPwdMap.get("salt"));
            sysUser.setUserPw(saltPwdMap.get("pwd"));
            //保存节点信息【重新保存方法，设置盐加密】
            sysUserService.save(sysUser);
        }

        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
    }

    /**
     * 更改密码
     * @param userCd       用户代码
     * @param userPwd      新密码
     * @return
     */
    @RequestMapping(value = "updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public ResultViewModel updateOrg(
            @RequestParam(value = "userCd", required = true) String userCd,
            @RequestParam(value = "userPwd", required = true) String userPwd,
            HttpServletRequest request
    ){
        SysUser user = sysUserService.getByUniqueKey("userCd", userCd, SysUser.class);
        //设置密码盐
        Map<String, String> saltPwdMap = sysUserService.setSaltPwd(userPwd);
        user.setUserSalt(saltPwdMap.get("salt"));
        user.setUserPw(saltPwdMap.get("pwd"));
        sysUserService.updateByPrimaryKeySelective(user);
        return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
    }

    /**
     * 删除用户
     * @param userId      用户主键
     * @return
     */
    @RequestMapping(value = "deleteUser", method = RequestMethod.GET)
    @ResponseBody
    public ResultViewModel deleteUser(
            @RequestParam(value = "userId", required = true) String userId
    ){
        try{
            //获取删除前信息
            SysUser user = sysUserService.getByPrimaryKey(userId);

            if(user != null){
                //删除用户
                sysUserService.deleteByPrimaryKey(userId);

                //删除用户权限
                sysUsermenuService.deleteByProperty("userCd", user.getUserCd(), SearchTypeEnum.EQ.getValue(), SysUsermenu.class);
            }
            //返回
            return new ResultViewModel(ResultViewModel.StateEnum.NORMAL.getValue());
        }catch (Exception e){
            e.printStackTrace();
            return new ResultViewModel(ResultViewModel.StateEnum.ABNORMAL.getValue());
        }
    }

}
