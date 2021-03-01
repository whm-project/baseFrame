package com.my.frame.service;

import com.my.base.BaseService;
import com.my.frame.model.SysOrg;

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
public interface SysOrgService extends BaseService<SysOrg> {

    /**
     * 设置组织机构是否是父节点
     * @param orgCd
     */
    void  setOrgIsParent(String orgCd);

    /**
     * 更新节点cd，子节点的index需要一起修改【只修改下级，不改自己】
     * @param old_orgCd
     * @param new_orgCd
     * @param orgId         自己节点的id，为了不改自己
     */
    void updateOrgCd(String old_orgCd, String new_orgCd, Long orgId);

    /**
     * 修改上级组织机构cd，两个相关的上级节点的是否是父级节点需要一起修改【只修改下级，不改自己】
     * @param old_eng_man_cd
     * @param new_eng_man_cd
     * @param orgCd
     * @param orgId         自己节点的id，为了不改自己
     */
    void updateEngManCd(String old_eng_man_cd, String new_eng_man_cd, String orgCd, Long orgId);

    /**
     * 修改组织机构，会判断是否修改上级组织机构cd，是否修改了本机组织机构cd
     * @param sysOrg
     * @return {newSupMenuCd: xxxx, oldSupMenuCd:xxxx}
     */
    Map<String, Object> updateSysOrg(SysOrg sysOrg);

    /**
     * 验证组织机构
     * @param orgCd
     * @param prefix_orgCd
     * @return
     */
    boolean checkContainOrgCd(String orgCd, String prefix_orgCd);
}
