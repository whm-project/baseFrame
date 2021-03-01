package com.my.frame.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_org")
public class SysOrg implements Serializable {
    /**
     * 组织机构名称
     */
    @Column(name = "ORG_NM")
    private String orgNm;

    @Id
    @Column(name = "org_id")
    private Long orgId;

    /**
     * 组织机构代码
     */
    @Column(name = "ORG_CD")
    private String orgCd;

    /**
     * 组织机构类型
     */
    @Column(name = "ORG_TYPE")
    private Integer orgType;

    /**
     * 组织机构简称
     */
    @Column(name = "ORG_SHNM")
    private String orgShnm;

    /**
     * 联系人
     */
    @Column(name = "CONTACT")
    private String contact;

    /**
     * 联系电话
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name = "E_MAIL")
    private String eMail;

    /**
     * 行政区划代码
     */
    @Column(name = "AD_CD")
    private String adCd;

    /**
     * 地址
     */
    @Column(name = "ADDR")
    private String addr;

    /**
     * 办公室电话
     */
    @Column(name = "TEL")
    private String tel;

    /**
     * 传真号码
     */
    @Column(name = "FAX")
    private String fax;

    /**
     * 备注
     */
    @Column(name = "NT")
    private String nt;

    /**
     * 状态
     */
    @Column(name = "ORG_STATUS")
    private Integer orgStatus;

    /**
     * 所属组织机构代码
     */
    @Column(name = "ENG_MAN_CD")
    private String engManCd;

    /**
     * 主要业务内容
     */
    @Column(name = "MAJ_BUS")
    private String majBus;

    /**
     * 时间戳
     */
    @Column(name = "TS")
    private Date ts;

    @Column(name = "ORG_ISPARENT")
    private Short orgIsparent;

    @Column(name = "ORG_IMG")
    private String orgImg;

    @Column(name = "ORG_ORDER")
    private Integer orgOrder;

    /**
     * 首页地址
     */
    @Column(name = "ORG_WELCOME")
    private String orgWelcome;

    /**
     * 布局库
     */
    @Column(name = "ORG_LAYOUTLIB")
    private String orgLayoutlib;

    /**
     * 样式库
     */
    @Column(name = "ORG_STYLELIB")
    private String orgStylelib;

    /**
     * 登录背景图
     */
    @Column(name = "login_bgImg")
    private String loginBgimg;

    /**
     * 索引
     */
    @Column(name = "ORG_INDEX")
    private String orgIndex;

    private static final long serialVersionUID = 1L;

    /**
     * 获取组织机构名称
     *
     * @return ORG_NM - 组织机构名称
     */
    public String getOrgNm() {
        return orgNm;
    }

    /**
     * 设置组织机构名称
     *
     * @param orgNm 组织机构名称
     */
    public void setOrgNm(String orgNm) {
        this.orgNm = orgNm;
    }

    /**
     * @return org_id
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * @param orgId
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取组织机构代码
     *
     * @return ORG_CD - 组织机构代码
     */
    public String getOrgCd() {
        return orgCd;
    }

    /**
     * 设置组织机构代码
     *
     * @param orgCd 组织机构代码
     */
    public void setOrgCd(String orgCd) {
        this.orgCd = orgCd;
    }

    /**
     * 获取组织机构类型
     *
     * @return ORG_TYPE - 组织机构类型
     */
    public Integer getOrgType() {
        return orgType;
    }

    /**
     * 设置组织机构类型
     *
     * @param orgType 组织机构类型
     */
    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    /**
     * 获取组织机构简称
     *
     * @return ORG_SHNM - 组织机构简称
     */
    public String getOrgShnm() {
        return orgShnm;
    }

    /**
     * 设置组织机构简称
     *
     * @param orgShnm 组织机构简称
     */
    public void setOrgShnm(String orgShnm) {
        this.orgShnm = orgShnm;
    }

    /**
     * 获取联系人
     *
     * @return CONTACT - 联系人
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系人
     *
     * @param contact 联系人
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取联系电话
     *
     * @return PHONE - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return E_MAIL - 邮箱
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * 设置邮箱
     *
     * @param eMail 邮箱
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * 获取行政区划代码
     *
     * @return AD_CD - 行政区划代码
     */
    public String getAdCd() {
        return adCd;
    }

    /**
     * 设置行政区划代码
     *
     * @param adCd 行政区划代码
     */
    public void setAdCd(String adCd) {
        this.adCd = adCd;
    }

    /**
     * 获取地址
     *
     * @return ADDR - 地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置地址
     *
     * @param addr 地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 获取办公室电话
     *
     * @return TEL - 办公室电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置办公室电话
     *
     * @param tel 办公室电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取传真号码
     *
     * @return FAX - 传真号码
     */
    public String getFax() {
        return fax;
    }

    /**
     * 设置传真号码
     *
     * @param fax 传真号码
     */
    public void setFax(String fax) {
        this.fax = fax;
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
     * 获取状态
     *
     * @return ORG_STATUS - 状态
     */
    public Integer getOrgStatus() {
        return orgStatus;
    }

    /**
     * 设置状态
     *
     * @param orgStatus 状态
     */
    public void setOrgStatus(Integer orgStatus) {
        this.orgStatus = orgStatus;
    }

    /**
     * 获取所属组织机构代码
     *
     * @return ENG_MAN_CD - 所属组织机构代码
     */
    public String getEngManCd() {
        return engManCd;
    }

    /**
     * 设置所属组织机构代码
     *
     * @param engManCd 所属组织机构代码
     */
    public void setEngManCd(String engManCd) {
        this.engManCd = engManCd;
    }

    /**
     * 获取主要业务内容
     *
     * @return MAJ_BUS - 主要业务内容
     */
    public String getMajBus() {
        return majBus;
    }

    /**
     * 设置主要业务内容
     *
     * @param majBus 主要业务内容
     */
    public void setMajBus(String majBus) {
        this.majBus = majBus;
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
     * @return ORG_ISPARENT
     */
    public Short getOrgIsparent() {
        return orgIsparent;
    }

    /**
     * @param orgIsparent
     */
    public void setOrgIsparent(Short orgIsparent) {
        this.orgIsparent = orgIsparent;
    }

    /**
     * @return ORG_IMG
     */
    public String getOrgImg() {
        return orgImg;
    }

    /**
     * @param orgImg
     */
    public void setOrgImg(String orgImg) {
        this.orgImg = orgImg;
    }

    /**
     * @return ORG_ORDER
     */
    public Integer getOrgOrder() {
        return orgOrder;
    }

    /**
     * @param orgOrder
     */
    public void setOrgOrder(Integer orgOrder) {
        this.orgOrder = orgOrder;
    }

    /**
     * 获取首页地址
     *
     * @return ORG_WELCOME - 首页地址
     */
    public String getOrgWelcome() {
        return orgWelcome;
    }

    /**
     * 设置首页地址
     *
     * @param orgWelcome 首页地址
     */
    public void setOrgWelcome(String orgWelcome) {
        this.orgWelcome = orgWelcome;
    }

    /**
     * 获取布局库
     *
     * @return ORG_LAYOUTLIB - 布局库
     */
    public String getOrgLayoutlib() {
        return orgLayoutlib;
    }

    /**
     * 设置布局库
     *
     * @param orgLayoutlib 布局库
     */
    public void setOrgLayoutlib(String orgLayoutlib) {
        this.orgLayoutlib = orgLayoutlib;
    }

    /**
     * 获取样式库
     *
     * @return ORG_STYLELIB - 样式库
     */
    public String getOrgStylelib() {
        return orgStylelib;
    }

    /**
     * 设置样式库
     *
     * @param orgStylelib 样式库
     */
    public void setOrgStylelib(String orgStylelib) {
        this.orgStylelib = orgStylelib;
    }

    /**
     * @return login_bgImg
     */
    public String getLoginBgimg() {
        return loginBgimg;
    }

    /**
     * @param loginBgimg
     */
    public void setLoginBgimg(String loginBgimg) {
        this.loginBgimg = loginBgimg;
    }

    /**
     * 获取索引
     *
     * @return ORG_INDEX - 索引
     */
    public String getOrgIndex() {
        return orgIndex;
    }

    /**
     * 设置索引
     *
     * @param orgIndex 索引
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
        sb.append(", orgNm=").append(orgNm);
        sb.append(", orgId=").append(orgId);
        sb.append(", orgCd=").append(orgCd);
        sb.append(", orgType=").append(orgType);
        sb.append(", orgShnm=").append(orgShnm);
        sb.append(", contact=").append(contact);
        sb.append(", phone=").append(phone);
        sb.append(", eMail=").append(eMail);
        sb.append(", adCd=").append(adCd);
        sb.append(", addr=").append(addr);
        sb.append(", tel=").append(tel);
        sb.append(", fax=").append(fax);
        sb.append(", nt=").append(nt);
        sb.append(", orgStatus=").append(orgStatus);
        sb.append(", engManCd=").append(engManCd);
        sb.append(", majBus=").append(majBus);
        sb.append(", ts=").append(ts);
        sb.append(", orgIsparent=").append(orgIsparent);
        sb.append(", orgImg=").append(orgImg);
        sb.append(", orgOrder=").append(orgOrder);
        sb.append(", orgWelcome=").append(orgWelcome);
        sb.append(", orgStylelib=").append(orgStylelib);
        sb.append(", loginBgimg=").append(loginBgimg);
        sb.append(", orgIndex=").append(orgIndex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public enum OrgTypeEnum{

        /**
         * 公司
         */
        COMPANY(1, "公司"),
        /**
         * 部门
         */
        DEPARTMENT(2, "部门");

        private Integer value;
        private String descript;

        OrgTypeEnum(Integer value, String descript){
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