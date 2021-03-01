package com.my.frame.dao;

import com.github.pagehelper.PageInfo;
import com.my.base.BaseDao;
import com.my.frame.model.SysUser;
import com.my.frame.model.querymodel.SysUserQueryModel;
import com.my.frame.model.viewModel.SysUserViewModel;

import java.util.List;

public interface SysUserDao extends BaseDao<SysUser> {

    /**
     * 关联组织机构表，获取用户
     * @param userQueryModel
     * @return
     */
    List<SysUserViewModel> findPageInfo(SysUserQueryModel userQueryModel);
}