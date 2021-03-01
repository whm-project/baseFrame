package com.my.frame.model.querymodel;

import com.my.base.BaseQueryModel;
import java.io.Serializable;

public class SysUserroleQueryModel extends BaseQueryModel implements Serializable {
    /**
     * 主键
     * 
     * @mbg.generated
     */
    private Long userroleId;

    /**
     * 用户id
     * 
     * @mbg.generated
     */
    private String userId;

    /**
     * 角色code
     * 
     * @mbg.generated
     */
    private String roleCd;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return USERROLE_ID - 主键
     *
     * @mbg.generated
     */
    public Long getUserroleId() {
        return userroleId;
    }

    /**
     * 设置主键
     *
     * @param userroleId 主键
     *
     * @mbg.generated
     */
    public void setUserroleId(Long userroleId) {
        this.userroleId = userroleId;
    }

    /**
     * 获取用户id
     *
     * @return USER_ID - 用户id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userroleId=").append(userroleId);
        sb.append(", userId=").append(userId);
        sb.append(", roleCd=").append(roleCd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}