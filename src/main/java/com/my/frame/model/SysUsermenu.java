package com.my.frame.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_usermenu")
public class SysUsermenu implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "USERMENU_ID")
    private Long usermenuId;

    /**
     * 角色code
     */
    @Column(name = "MENU_CD")
    private String menuCd;

    /**
     * 登录名
     */
    @Column(name = "USER_CD")
    private String userCd;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return USERMENU_ID - 主键
     */
    public Long getUsermenuId() {
        return usermenuId;
    }

    /**
     * 设置主键
     *
     * @param usermenuId 主键
     */
    public void setUsermenuId(Long usermenuId) {
        this.usermenuId = usermenuId;
    }

    /**
     * 获取角色code
     *
     * @return MENU_CD - 角色code
     */
    public String getMenuCd() {
        return menuCd;
    }

    /**
     * 设置角色code
     *
     * @param menuCd 角色code
     */
    public void setMenuCd(String menuCd) {
        this.menuCd = menuCd;
    }

    /**
     * 获取登录名
     *
     * @return USER_CD - 登录名
     */
    public String getUserCd() {
        return userCd;
    }

    /**
     * 设置登录名
     *
     * @param userCd 登录名
     */
    public void setUserCd(String userCd) {
        this.userCd = userCd;
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
        sb.append(", usermenuId=").append(usermenuId);
        sb.append(", menuCd=").append(menuCd);
        sb.append(", userCd=").append(userCd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}