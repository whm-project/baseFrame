package com.my.frame.service.impl;

import com.my.base.BaseServiceImpl;
import com.my.frame.dao.SysUserroleDao;
import com.my.frame.model.SysUserrole;
import com.my.frame.service.SysUserroleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author
 * @version 0.0.1
 * @date 2018/08/23
 * @time 09:53
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserroleServiceImpl extends BaseServiceImpl<SysUserrole> implements SysUserroleService {

    @Resource
    private SysUserroleDao sysUserroleMapper;

}
