package com.my.frame.model.querymodel;

import com.my.base.BaseQueryModel;
import java.io.Serializable;
import java.util.Date;

public class SysMenuQueryModel extends BaseQueryModel implements Serializable {
    /**
     * 主键
     * 
     * @mbg.generated
     */
    private Long menuId;

    /**
     * 菜单code
     * 
     * @mbg.generated
     */
    private String menuCd;

    /**
     * 菜单名称
     * 
     * @mbg.generated
     */
    private String menuNm;

    /**
     * 菜单排序值
     * 
     * @mbg.generated
     */
    private Integer menuOrder;

    /**
     * 父级菜单code
     * 
     * @mbg.generated
     */
    private String supMenuCd;

    /**
     * 菜单url
     * 
     * @mbg.generated
     */
    private String menuUrl;

    /**
     * 菜单类型
     * 
     * @mbg.generated
     */
    private String menuType;

    /**
     * 时间戳
     * 
     * @mbg.generated
     */
    private Date ts;

    /**
     * 备注
     * 
     * @mbg.generated
     */
    private String nt;

    /**
     * 是否有子级
     * 
     * @mbg.generated
     */
    private Short menuIsparent;

    /**
     * 页面类型
     * 
     * @mbg.generated
     */
    private String pageType;

    /**
     * 按钮位置
     * 
     * @mbg.generated
     */
    private String btnPosition;

    /**
     * 按钮方法
     */
    private String menuOther1;

    /**
     * 打开图标
     */
    private String menuOther2;

    /**
     * 关闭图标
     */
    private String menuOther3;

    /**
     * 必选
     */
    private String menuOther4;

    /**
     *
     */
    private String menuOther5;

    /**
     *
     */
    private String menuOther6;

    /**
     * 菜单索引
     * 
     * @mbg.generated
     */
    private String menuIndex;

    /**
     * 菜单图片
     * 
     * @mbg.generated
     */
    private String menuImg;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return MENU_ID - 主键
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置主键
     *
     * @param menuId 主键
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取菜单code
     *
     * @return MENU_CD - 菜单code
     */
    public String getMenuCd() {
        return menuCd;
    }

    /**
     * 设置菜单code
     *
     * @param menuCd 菜单code
     */
    public void setMenuCd(String menuCd) {
        this.menuCd = menuCd;
    }

    /**
     * 获取菜单名称
     *
     * @return MENU_NM - 菜单名称
     */
    public String getMenuNm() {
        return menuNm;
    }

    /**
     * 设置菜单名称
     *
     * @param menuNm 菜单名称
     */
    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }

    /**
     * 获取菜单排序值
     *
     * @return MENU_ORDER - 菜单排序值
     */
    public Integer getMenuOrder() {
        return menuOrder;
    }

    /**
     * 设置菜单排序值
     *
     * @param menuOrder 菜单排序值
     */
    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    /**
     * 获取父级菜单code
     *
     * @return SUP_MENU_CD - 父级菜单code
     */
    public String getSupMenuCd() {
        return supMenuCd;
    }

    /**
     * 设置父级菜单code
     *
     * @param supMenuCd 父级菜单code
     */
    public void setSupMenuCd(String supMenuCd) {
        this.supMenuCd = supMenuCd;
    }

    /**
     * 获取菜单url
     *
     * @return MENU_URL - 菜单url
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置菜单url
     *
     * @param menuUrl 菜单url
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * 获取菜单类型
     *
     * @return MENU_TYPE - 菜单类型
     */
    public String getMenuType() {
        return menuType;
    }

    /**
     * 设置菜单类型
     *
     * @param menuType 菜单类型
     */
    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    /**
     * 获取时间戳
     *
     * @return TS - 时间戳
     */
    public Date getTs() {
        return ts;
    }

    /**
     * 设置时间戳
     *
     * @param ts 时间戳
     */
    public void setTs(Date ts) {
        this.ts = ts;
    }

    /**
     * 获取备注
     *
     * @return NT - 备注
     */
    public String getNt() {
        return nt;
    }

    /**
     * 设置备注
     *
     * @param nt 备注
     */
    public void setNt(String nt) {
        this.nt = nt;
    }

    /**
     * 获取是否有子级
     *
     * @return MENU_ISPARENT - 是否有子级
     */
    public Short getMenuIsparent() {
        return menuIsparent;
    }

    /**
     * 设置是否有子级
     *
     * @param menuIsparent 是否有子级
     */
    public void setMenuIsparent(Short menuIsparent) {
        this.menuIsparent = menuIsparent;
    }

    /**
     * 获取页面类型
     *
     * @return PAGE_TYPE - 页面类型
     */
    public String getPageType() {
        return pageType;
    }

    /**
     * 设置页面类型
     *
     * @param pageType 页面类型
     */
    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    /**
     * 获取按钮位置
     *
     * @return BTN_POSITION - 按钮位置
     */
    public String getBtnPosition() {
        return btnPosition;
    }

    /**
     * 设置按钮位置
     *
     * @param btnPosition 按钮位置
     */
    public void setBtnPosition(String btnPosition) {
        this.btnPosition = btnPosition;
    }

    /**
     * @return MENU_OTHER1
     */
    public String getMenuOther1() {
        return menuOther1;
    }

    /**
     * @param menuOther1
     */
    public void setMenuOther1(String menuOther1) {
        this.menuOther1 = menuOther1;
    }

    /**
     * @return MENU_OTHER2
     */
    public String getMenuOther2() {
        return menuOther2;
    }

    /**
     * @param menuOther2
     */
    public void setMenuOther2(String menuOther2) {
        this.menuOther2 = menuOther2;
    }

    /**
     * @return MENU_OTHER3
     */
    public String getMenuOther3() {
        return menuOther3;
    }

    /**
     * @param menuOther3
     */
    public void setMenuOther3(String menuOther3) {
        this.menuOther3 = menuOther3;
    }

    /**
     * @return MENU_OTHER4
     */
    public String getMenuOther4() {
        return menuOther4;
    }

    /**
     * @param menuOther4
     */
    public void setMenuOther4(String menuOther4) {
        this.menuOther4 = menuOther4;
    }

    /**
     * @return MENU_OTHER5
     */
    public String getMenuOther5() {
        return menuOther5;
    }

    /**
     * @param menuOther5
     */
    public void setMenuOther5(String menuOther5) {
        this.menuOther5 = menuOther5;
    }

    /**
     * @return MENU_OTHER6
     */
    public String getMenuOther6() {
        return menuOther6;
    }

    /**
     * @param menuOther6
     */
    public void setMenuOther6(String menuOther6) {
        this.menuOther6 = menuOther6;
    }

    /**
     * 获取菜单索引
     *
     * @return MENU_INDEX - 菜单索引
     */
    public String getMenuIndex() {
        return menuIndex;
    }

    /**
     * 设置菜单索引
     *
     * @param menuIndex 菜单索引
     */
    public void setMenuIndex(String menuIndex) {
        this.menuIndex = menuIndex;
    }

    /**
     * 获取菜单图片
     *
     * @return MENU_IMG - 菜单图片
     */
    public String getMenuImg() {
        return menuImg;
    }

    /**
     * 设置菜单图片
     *
     * @param menuImg 菜单图片
     */
    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
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
        sb.append(", menuId=").append(menuId);
        sb.append(", menuCd=").append(menuCd);
        sb.append(", menuNm=").append(menuNm);
        sb.append(", menuOrder=").append(menuOrder);
        sb.append(", supMenuCd=").append(supMenuCd);
        sb.append(", menuUrl=").append(menuUrl);
        sb.append(", menuType=").append(menuType);
        sb.append(", ts=").append(ts);
        sb.append(", nt=").append(nt);
        sb.append(", menuIsparent=").append(menuIsparent);
        sb.append(", pageType=").append(pageType);
        sb.append(", btnPosition=").append(btnPosition);
        sb.append(", menuOther1=").append(menuOther1);
        sb.append(", menuOther2=").append(menuOther2);
        sb.append(", menuOther3=").append(menuOther3);
        sb.append(", menuOther4=").append(menuOther4);
        sb.append(", menuOther5=").append(menuOther5);
        sb.append(", menuOther6=").append(menuOther6);
        sb.append(", menuIndex=").append(menuIndex);
        sb.append(", menuImg=").append(menuImg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}