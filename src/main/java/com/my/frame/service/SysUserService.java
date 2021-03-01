package com.my.frame.service;

import com.github.pagehelper.PageInfo;
import com.my.base.BaseService;
import com.my.frame.model.SysUser;
import com.my.frame.model.querymodel.SysUserQueryModel;
import com.my.frame.model.viewModel.SysUserViewModel;

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
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 设置盐加密
     * @param pwd
     * @return {salt:盐, pwd:加密后密码}
     */
    Map<String, String> setSaltPwd(String pwd);

    /**
     * 根据用户名密码，获取用户信息
     * @param userCd
     * @param userPw
     * @return
     */
    SysUser getUserInfo(String userCd, String userPw);

    /**
     * 获取用户
     * @param userQueryModel
     * @return
     */
    PageInfo<SysUserViewModel> findPageInfo(SysUserQueryModel userQueryModel);

    /**
     * 修改用户组织机构编码
     * @param old_orgCd
     * @param new_orgCd
     */
    void updateUserOrg(String old_orgCd, String new_orgCd);
}
