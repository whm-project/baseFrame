package com.my.frame.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "MENU_ID")
    private Long menuId;

    /**
     * 菜单code
     */
    @Column(name = "MENU_CD")
    private String menuCd;

    /**
     * 菜单名称
     */
    @Column(name = "MENU_NM")
    private String menuNm;

    /**
     * 菜单排序值
     */
    @Column(name = "MENU_ORDER")
    private Integer menuOrder;

    /**
     * 父级菜单code
     */
    @Column(name = "SUP_MENU_CD")
    private String supMenuCd;

    /**
     * 菜单url
     */
    @Column(name = "MENU_URL")
    private String menuUrl;

    /**
     * 菜单类型
     */
    @Column(name = "MENU_TYPE")
    private String menuType;

    /**
     * 时间戳
     */
    @Column(name = "TS")
    private Date ts;

    /**
     * 备注
     */
    @Column(name = "NT")
    private String nt;

    /**
     * 是否有子级
     */
    @Column(name = "MENU_ISPARENT")
    private Short menuIsparent;

    /**
     * 页面类型
     */
    @Column(name = "PAGE_TYPE")
    private String pageType;

    /**
     * 按钮位置
     */
    @Column(name = "BTN_POSITION")
    private String btnPosition;

    /**
     * 按钮方法
     */
    @Column(name = "MENU_OTHER1")
    private String menuOther1;

    /**
     * 打开图标
     */
    @Column(name = "MENU_OTHER2")
    private String menuOther2;

    /**
     * 关闭图标
     */
    @Column(name = "MENU_OTHER3")
    private String menuOther3;

    /**
     * 必选
     */
    @Column(name = "MENU_OTHER4")
    private String menuOther4;

    /**
     *
     */
    @Column(name = "MENU_OTHER5")
    private String menuOther5;

    /**
     *
     */
    @Column(name = "MENU_OTHER6")
    private String menuOther6;

    /**
     * 菜单索引
     */
    @Column(name = "MENU_INDEX")
    private String menuIndex;

    /**
     * 菜单图片
     */
    @Column(name = "MENU_IMG")
    private String menuImg;

    /**
     * 菜单名称类型
     */
    @Transient
    private String menuNmLx;

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
     * 获取菜单名称类型
     */
    public String getMenuNmLx() {
        String menuNmLx = this.menuNm;
        try {
            if (this.menuType.equals("1")) {
                menuNmLx += "（模块）";
            }
            if (this.menuType.equals("2")) {
                if (this.pageType.equals("1")) {
                    menuNmLx += "（单页）";
                }
                if (this.pageType.equals("2")) {
                    menuNmLx += "（多页）";
                }
            }
            if (this.menuType.equals("3")) {
                menuNmLx += "（按钮）";
            }
        }catch (Exception e){

        }
        return menuNmLx;
    }

    /**
     * 设置菜单名称类型
     */
    public void setMenuNmLx(String menuNmLx) {
        this.menuNmLx = menuNmLx;
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

    /**
     * 菜单类型
     */
    public enum MenuTypeEnum{

        /**
         * 菜单
         */
        MODEL(1, "模块"),
        /**
         * 页面
         */
        PAGE(2, "页面"),
        /**
         * 按钮
         */
        BUTTON(3, "按钮");

        private Integer value;
        private String descript;

        MenuTypeEnum(Integer value, String descript){
            this.value = value;
            this.descript = descript;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getDescript() {
            return descript;
        }

        public void setDescript(String descript) {
            this.descript = descript;
        }
    }

    /**
     * 页面类型
     */
    public enum PageTypeEnum{

        /**
         * 单页
         */
        SINGLE(1, "单页"),
        /**
         * 多页
         */
        MULTI(2, "多页");

        private Integer value;
        private String descript;

        PageTypeEnum(Integer value, String descript){
            this.value = value;
            this.descript = descript;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getDescript() {
            return descript;
        }

        public void setDescript(String descript) {
            this.descript = descript;
        }
    }

    /**
     * 按钮位置
     */
    public enum BtnPositionEnum{

        /**
         * 按钮栏
         */
        BUTTONBAR(1, "按钮栏"),
        /**
         * 操作栏
         */
        ACTIONBAR(2, "操作栏");

        private Integer value;
        private String descript;

        BtnPositionEnum(Integer value, String descript){
            this.value = value;
            this.descript = descript;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getDescript() {
            return descript;
        }

        public void setDescript(String descript) {
            this.descript = descript;
        }
    }
}