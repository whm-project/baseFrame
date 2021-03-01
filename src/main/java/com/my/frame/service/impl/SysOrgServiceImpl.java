package com.my.frame.service.impl;

import com.my.base.BaseServiceImpl;
import com.my.base.SearchTypeEnum;
import com.my.frame.dao.SysOrgDao;
import com.my.frame.model.SysOrg;
import com.my.commonEnum.IsParentEnum;
import com.my.frame.service.SysOrgService;
import com.my.frame.service.SysRoleService;
import com.my.frame.service.SysUserService;
import com.my.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
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
@Service("sysOrgServiceImpl")
@Transactional(rollbackFor = Exception.class)
public class SysOrgServiceImpl extends BaseServiceImpl<SysOrg> implements SysOrgService {

    @Resource
    private SysOrgDao sysOrgMapper;
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysRoleService roleService;

    /**
     * 设置组织机构是否是父节点
     * @param orgCd
     */
    @Override
    public void setOrgIsParent(String orgCd) {
        //查询结果
        List<SysOrg> childOrgList = findInfo("engManCd", orgCd, SearchTypeEnum.EQ.getValue(), "orgOrder", SysOrg.class);

        SysOrg org = new SysOrg();
        //设置是否有子节点
        if(childOrgList.size() > 0){
            org.setOrgIsparent(IsParentEnum.HASCHILD.getValue());
        }else{
            org.setOrgIsparent(IsParentEnum.NOCHILD.getValue());
        }
        updateInfoSelective(org, "orgCd", orgCd, SearchTypeEnum.EQ.getValue(), SysOrg.class);
    }

    /**
     * 更新节点cd，子节点的index需要一起修改【只修改下级，不改自己】
     * @param old_orgCd
     * @param new_orgCd
     * @param orgId         自己节点的id，为了不改自己
     */
    @Override
    public void updateOrgCd(String old_orgCd, String new_orgCd, Long orgId) {
        //查询原cd下的子节点
        List<SysOrg> childOrgList = findInfo("orgIndex", "%"+old_orgCd+"%", SearchTypeEnum.LIKE.getValue(), "orgOrder", SysOrg.class);

        //循环子节点
        for(SysOrg childOrg : childOrgList){
            //如果是自己，不用修改
            if(childOrg.getOrgId().equals(orgId)){
                continue;
            }
            //如果该子节点是直接子节点
            if(childOrg.getEngManCd().equals(old_orgCd)){
                //设置父节点是新cd
                childOrg.setEngManCd(new_orgCd);
            }
            //设置子节点的索引
            String child_org_index = childOrg.getOrgIndex().replace(old_orgCd, new_orgCd);
            childOrg.setOrgIndex(child_org_index);
            //更新
            updateByPrimaryKeySelective(childOrg);
        }
    }

    /**
     * 修改上级组织机构cd，两个相关的上级节点的是否是父级节点需要一起修改【只修改下级，不改自己】
     * @param old_eng_man_cd
     * @param new_eng_man_cd
     * @param orgCd
     * @param orgId         自己节点的id，为了不改自己
     */
    @Override
    public void updateEngManCd(String old_eng_man_cd, String new_eng_man_cd, String orgCd, Long orgId) {
        String old_eng_man_index = getByUniqueKey("orgCd", old_eng_man_cd, SysOrg.class).getOrgIndex();
        String new_eng_man_index = getByUniqueKey("orgCd", new_eng_man_cd, SysOrg.class).getOrgIndex();

        //查询原cd下的子节点
        List<SysOrg> childOrgList = findInfo("orgIndex", "%"+orgCd+"%", SearchTypeEnum.LIKE.getValue(), "orgOrder", SysOrg.class);
        //循环子节点
        for(SysOrg childOrg : childOrgList){
            //如果是自己，不用修改
            if(childOrg.getOrgId().equals(orgId)){
                continue;
            }
            //设置子节点的索引
            String child_org_index = childOrg.getOrgIndex().replace(old_eng_man_index, new_eng_man_index);
            childOrg.setOrgIndex(child_org_index);
            //更新
            updateByPrimaryKeySelective(childOrg);
        }

        //更新上级组织机构是否还有子节点
        setOrgIsParent(old_eng_man_cd);
        setOrgIsParent(new_eng_man_cd);
    }


    /**
     * 修改组织机构，会判断是否修改上级组织机构cd，是否修改了本机组织机构cd
     * @param sysOrg
     * @return  {newSupMenuCd: xxxx, oldSupMenuCd:xxxx}
     */
    @Override
    public Map<String, Object> updateSysOrg(SysOrg sysOrg) {
        Long orgId = sysOrg.getOrgId();

        //原节点信息
        SysOrg old_org = getByPrimaryKey(orgId);
        //原节点cd
        String old_orgCd = old_org.getOrgCd();
        //原上级节点
        String old_eng_man_cd = old_org.getEngManCd();

        //更新节点信息
        updateByPrimaryKeySelective(sysOrg);

        //新节点编码
        String new_orgCd = sysOrg.getOrgCd();
        //新上级节点
        String new_eng_man_cd = StringUtil.notNull(sysOrg.getEngManCd());

        //如果两个cd不相同，该节点下子节点的上级组织机构和组织机构索引需要进行修改
        if(!old_orgCd.equals(new_orgCd)){
            updateOrgCd(old_orgCd, new_orgCd, orgId);

            //改变用户表的组织机构编码
            userService.updateUserOrg(old_orgCd, new_orgCd);
            //改变角色表的组织机构编码
            roleService.updateRoleOrg(old_orgCd, new_orgCd);
        }

        //如果上级节点变了，需要设置新旧两个上级节点的是否还有子节点属性，并且修改当前节点下级节点的索引
        if(!old_eng_man_cd.equals(new_eng_man_cd)){
            updateEngManCd(old_eng_man_cd, new_eng_man_cd, new_orgCd, orgId);
        }

        Map resultMap = new HashMap<String, Object>();
        resultMap.put("newEngManCd", new_eng_man_cd);
        resultMap.put("oldEngManCd", old_eng_man_cd);
        return resultMap;
    }

    /**
     * 验证组织机构
     * @param user_orgCd
     * @param obj_orgCd
     * @return
     */
    @Override
    public boolean checkContainOrgCd(String user_orgCd, String obj_orgCd){
        SysOrg obj_org = getByUniqueKey("orgCd", obj_orgCd, SysOrg.class);
        if(obj_org.getOrgIndex().contains(user_orgCd)){
            return true;
        }
        return false;
    }

}
