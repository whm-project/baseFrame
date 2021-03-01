package com.my.frame.model.querymodel;

import com.my.base.BaseQueryModel;
import java.io.Serializable;

public class SysRolemenuQueryModel extends BaseQueryModel implements Serializable {
    /**
     * 主键
     * 
     * @mbg.generated
     */
    private Long rolemenuId;

    /**
     * 角色code
     * 
     * @mbg.generated
     */
    private String roleCd;

    /**
     * 菜单code
     * 
     * @mbg.generated
     */
    private String menuCd;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return ROLEMENU_ID - 主键
     *
     * @mbg.generated
     */
    public Long getRolemenuId() {
        return rolemenuId;
    }

    /**
     * 设置主键
     *
     * @param rolemenuId 主键
     *
     * @mbg.generated
     */
    public void setRolemenuId(Long rolemenuId) {
        this.rolemenuId = rolemenuId;
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
     * 获取菜单code
     *
     * @return MENU_CD - 菜单code
     *
     * @mbg.generated
     */
    public String getMenuCd() {
        return menuCd;
    }

    /**
     * 设置菜单code
     *
     * @param menuCd 菜单code
     *
     * @mbg.generated
     */
    public void setMenuCd(String menuCd) {
        this.menuCd = menuCd;
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
        sb.append(", rolemenuId=").append(rolemenuId);
        sb.append(", roleCd=").append(roleCd);
        sb.append(", menuCd=").append(menuCd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}