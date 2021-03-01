package com.my.frame.model.querymodel;

import com.my.base.BaseQueryModel;
import java.io.Serializable;

public class SysUsermenuQueryModel extends BaseQueryModel implements Serializable {

    /**
     * 菜单Type
     *
     * @mbg.generated
     */
    private String menuType;

    /**
     * 父级菜单code
     *
     * @mbg.generated
     */
    private String supMenuCd;

    /**
     * 登录名
     * 
     * @mbg.generated
     */
    private String userCd;

    /**
     * 菜单code
     *
     * @mbg.generated
     */
    private String menuCd;

    /**
     * 用户状态
     *
     * @mbg.generated
     */
    private Integer userStatus;

    /**
     * 组织机构代码
     *
     * @mbg.generated
     */
    private String orgCd;

    /**
     * 基础按钮
     */
    private String baseBtn;

    /**
     * 按钮位置（1按钮栏，2操作栏）
     */
    private String btnPosition;

    private static final long serialVersionUID = 1L;

    /**
     * 获取菜单类型
     *
     * @return MENU_TYPE - 菜单类型
     *
     * @mbg.generated
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型
     *
     * @param menuType 菜单类型
     *
     * @mbg.generated
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取父级菜单code
     *
     * @return SUP_MENU_CD - 父级菜单code
     *
     * @mbg.generated
     */
    public String getSupMenuCd() {
        return supMenuCd;
    }

    /**
     * 设置父级菜单code
     *
     * @param supMenuCd 父级菜单code
     *
     * @mbg.generated
     */
    public void setSupMenuCd(String supMenuCd) {
        this.supMenuCd = supMenuCd;
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
     * 获取用户状态
     *
     * @return USER_STATUS - 用户状态
     *
     * @mbg.generated
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态
     *
     * @param userStatus 用户状态
     *
     * @mbg.generated
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
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

    public String getBaseBtn() {
        return baseBtn;
    }

    public void setBaseBtn(String baseBtn) {
        this.baseBtn = baseBtn;
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
        sb.append(", menuCd=").append(menuCd);
        sb.append(", menuType=").append(menuType);
        sb.append(", supMenuCd=").append(supMenuCd);
        sb.append(", userCd=").append(userCd);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", orgCd=").append(orgCd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public String getBtnPosition() {
        return btnPosition;
    }

    public void setBtnPosition(String btnPosition) {
        this.btnPosition = btnPosition;
    }
}