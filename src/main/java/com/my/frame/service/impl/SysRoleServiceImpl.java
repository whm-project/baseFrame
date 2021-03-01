package com.my.frame.service.impl;

import com.my.base.BaseServiceImpl;
import com.my.base.SearchTypeEnum;
import com.my.frame.dao.SysRoleDao;
import com.my.frame.model.SysRole;
import com.my.frame.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {

    @Resource
    private SysRoleDao sysRoleMapper;

    /**
     * 修改角色组织机构编码
     * @param old_orgCd
     * @param new_orgCd
     */
    @Override
    public void updateRoleOrg(String old_orgCd, String new_orgCd) {
        List<SysRole> roleList = findInfo("orgCd", old_orgCd, SearchTypeEnum.EQ.getValue(), "", SysRole.class);
        for(SysRole role : roleList){
            role.setOrgCd(new_orgCd);
            updateByPrimaryKeySelective(role);
        }
    }
}
