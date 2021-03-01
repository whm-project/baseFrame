package com.my.frame.model.querymodel;

import com.my.base.BaseQueryModel;
import java.io.Serializable;
import java.util.Date;

public class SysRoleQueryModel extends BaseQueryModel implements Serializable {
    /**
     * 主键
     * 
     * @mbg.generated
     */
    private Long roleId;

    /**
     * 角色名称
     * 
     * @mbg.generated
     */
    private String roleNm;

    /**
     * 角色code
     * 
     * @mbg.generated
     */
    private String roleCd;

    /**
     * 角色状态
     * 
     * @mbg.generated
     */
    private Integer roleStatus;

    /**
     * 备注
     * 
     * @mbg.generated
     */
    private String nt;

    /**
     * 时间戳
     * 
     * @mbg.generated
     */
    private Date ts;

    /**
     * 排序值
     * 
     * @mbg.generated
     */
    private Integer roleOrder;

    /**
     * 组织机构代码
     * 
     * @mbg.generated
     */
    private String orgCd;

    /**
     * 组织机构索引
     * 
     * @mbg.generated
     */
    private String orgIndex;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return ROLE_ID - 主键
     *
     * @mbg.generated
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置主键
     *
     * @param roleId 主键
     *
     * @mbg.generated
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称
     *
     * @return ROLE_NM - 角色名称
     *
     * @mbg.generated
     */
    public String getRoleNm() {
        return roleNm;
    }

    /**
     * 设置角色名称
     *
     * @param roleNm 角色名称
     *
     * @mbg.generated
     */
    public void setRoleNm(String roleNm) {
        this.roleNm = roleNm;
    }

    /**
     * 获取角色code
     *
     * @return ROLE_CD - 角色code
     *
     * @mbg.generated
     */
    public String getRoleCd() {
        return roleCd;
    }

    /**
     * 设置角色code
     *
     * @param roleCd 角色code
     *
     * @mbg.generated
     */
    public void setRoleCd(String roleCd) {
        this.roleCd = roleCd;
    }

    /**
     * 获取角色状态
     *
     * @return ROLE_STATUS - 角色状态
     *
     * @mbg.generated
     */
    public Integer getRoleStatus() {
        return roleStatus;
    }

    /**
     * 设置角色状态
     *
     * @param roleStatus 角色状态
     *
     * @mbg.generated
     */
    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    /**
     * 获取备注
     *
     * @return NT - 备注
     *
     * @mbg.generated
     */
    public String getNt() {
        return nt;
    }

    /**
     * 设置备注
     *
     * @param nt 备注
     *
     * @mbg.generated
     */
    public void setNt(String nt) {
        this.nt = nt;
    }

    /**
     * 获取时间戳
     *
     * @return TS - 时间戳
     *
     * @mbg.generated
     */
    public Date getTs() {
        return ts;
    }

    /**
     * 设置时间戳
     *
     * @param ts 时间戳
     *
     * @mbg.generated
     */
    public void setTs(Date ts) {
        this.ts = ts;
    }

    /**
     * 获取排序值
     *
     * @return ROLE_ORDER - 排序值
     *
     * @mbg.generated
     */
    public Integer getRoleOrder() {
        return roleOrder;
    }

    /**
     * 设置排序值
     *
     * @param roleOrder 排序值
     *
     * @mbg.generated
     */
    public void setRoleOrder(Integer roleOrder) {
        this.roleOrder = roleOrder;
    }

    /**
     * 获取组织机构代码
     *
     * @return ORG_CD - 组织机构代码
     *
     * @mbg.generated
     */
    public String getOrgCd() {
        return orgCd;
    }

    /**
     * 设置组织机构代码
     *
     * @param orgCd 组织机构代码
     *
     * @mbg.generated
     */
    public void setOrgCd(String orgCd) {
        this.orgCd = orgCd;
    }

    /**
     * 获取组织机构索引
     *
     * @return ORG_INDEX - 组织机构索引
     *
     * @mbg.generated
     */
    public String getOrgIndex() {
        return orgIndex;
    }

    /**
     * 设置组织机构索引
     *
     * @param orgIndex 组织机构索引
     *
     * @mbg.generated
     */
    public void setOrgIndex(String orgIndex) {
        this.orgIndex = orgIndex;
    }

    /**
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", roleNm=").append(roleNm);
        sb.append(", roleCd=").append(roleCd);
        sb.append(", roleStatus=").append(roleStatus);
        sb.append(", nt=").append(nt);
        sb.append(", ts=").append(ts);
        sb.append(", roleOrder=").append(roleOrder);
        sb.append(", orgCd=").append(orgCd);
        sb.append(", orgIndex=").append(orgIndex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}