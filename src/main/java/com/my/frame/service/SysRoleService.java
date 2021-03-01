package com.my.frame.service;

import com.github.pagehelper.PageInfo;
import com.my.base.BaseService;
import com.my.frame.model.SysRole;

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
public interface SysRoleService extends BaseService<SysRole> {

    /**
     * 修改角色组织机构编码
     * @param old_orgCd
     * @param new_orgCd
     */
    void updateRoleOrg(String old_orgCd, String new_orgCd);
}
