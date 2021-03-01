package com.my.frame.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser implements Serializable {
    /**
     * 自增
     * 
     * @mbg.generated
     */
    @Id
    @Column(name = "USER_ID")
    private Long userId;

    /**
     * 登录名
     * 
     * @mbg.generated
     */
    @Column(name = "USER_CD")
    private String userCd;

    /**
     * 姓名
     * 
     * @mbg.generated
     */
    @Column(name = "USER_NM")
    private String userNm;

    /**
     * 密码
     * 
     * @mbg.generated
     */
    @Column(name = "USER_PW")
    private String userPw;

    /**
     * 性别
     * 
     * @mbg.generated
     */
    @Column(name = "USER_SEX")
    private Integer userSex;

    /**
     * 用户状态
     * 
     * @mbg.generated
     */
    @Column(name = "USER_STATUS")
    private Integer userStatus;

    /**
     * 行政区划代码
     * 
     * @mbg.generated
     */
    @Column(name = "AD_CD")
    private String adCd;

    /**
     * 地址
     * 
     * @mbg.generated
     */
    @Column(name = "ADDR")
    private String addr;

    /**
     * 联系电话
     * 
     * @mbg.generated
     */
    @Column(name = "USER_TEL")
    private String userTel;

    /**
     * QQ
     * 
     * @mbg.generated
     */
    @Column(name = "USER_QQ")
    private String userQq;

    /**
     * 邮箱
     * 
     * @mbg.generated
     */
    @Column(name = "USER_E_MAIL")
    private String userEMail;

    /**
     * 时间戳
     * 
     * @mbg.generated
     */
    @Column(name = "TS")
    private Date ts;

    /**
     * 组织机构代码
     * 
     * @mbg.generated
     */
    @Column(name = "ORG_CD")
    private String orgCd;

    /**
     * 加密盐
     *
     * @mbg.generated
     */
    @Column(name = "USER_SALT")
    private String userSalt;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return USER_ID - 主键
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置主键
     *
     * @param userId 主键
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取登录名
     *
     * @return USER_CD - 登录名
     *
     * @mbg.generated
     */
    public String getUserCd() {
        return userCd;
    }

    /**
     * 设置登录名
     *
     * @param userCd 登录名
     *
     * @mbg.generated
     */
    public void setUserCd(String userCd) {
        this.userCd = userCd;
    }

    /**
     * 获取姓名
     *
     * @return USER_NM - 姓名
     *
     * @mbg.generated
     */
    public String getUserNm() {
        return userNm;
    }

    /**
     * 设置姓名
     *
     * @param userNm 姓名
     *
     * @mbg.generated
     */
    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    /**
     * 获取密码
     *
     * @return USER_PW - 密码
     *
     * @mbg.generated
     */
    public String getUserPw() {
        return userPw;
    }

    /**
     * 设置密码
     *
     * @param userPw 密码
     *
     * @mbg.generated
     */
    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    /**
     * 获取性别
     *
     * @return USER_SEX - 性别
     *
     * @mbg.generated
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * 设置性别
     *
     * @param userSex 性别
     *
     * @mbg.generated
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
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
     * 获取行政区划代码
     *
     * @return AD_CD - 行政区划代码
     *
     * @mbg.generated
     */
    public String getAdCd() {
        return adCd;
    }

    /**
     * 设置行政区划代码
     *
     * @param adCd 行政区划代码
     *
     * @mbg.generated
     */
    public void setAdCd(String adCd) {
        this.adCd = adCd;
    }

    /**
     * 获取地址
     *
     * @return ADDR - 地址
     *
     * @mbg.generated
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置地址
     *
     * @param addr 地址
     *
     * @mbg.generated
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 获取联系电话
     *
     * @return USER_TEL - 联系电话
     *
     * @mbg.generated
     */
    public String getUserTel() {
        return userTel;
    }

    /**
     * 设置联系电话
     *
     * @param userTel 联系电话
     *
     * @mbg.generated
     */
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    /**
     * 获取QQ
     *
     * @return USER_QQ - QQ
     *
     * @mbg.generated
     */
    public String getUserQq() {
        return userQq;
    }

    /**
     * 设置QQ
     *
     * @param userQq QQ
     *
     * @mbg.generated
     */
    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    /**
     * 获取邮箱
     *
     * @return USER_E_MAIL - 邮箱
     *
     * @mbg.generated
     */
    public String getUserEMail() {
        return userEMail;
    }

    /**
     * 设置邮箱
     *
     * @param userEMail 邮箱
     *
     * @mbg.generated
     */
    public void setUserEMail(String userEMail) {
        this.userEMail = userEMail;
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
     * 获取加密盐
     *
     * @return  userSalt - 加密盐
     */
    public String getUserSalt() {
        return userSalt;
    }

    /**
     * 设置加密盐
     *
     * @param userSalt 加密盐
     */
    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
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
        sb.append(", userId=").append(userId);
        sb.append(", userCd=").append(userCd);
        sb.append(", userNm=").append(userNm);
        sb.append(", userPw=").append(userPw);
        sb.append(", userSex=").append(userSex);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", adCd=").append(adCd);
        sb.append(", addr=").append(addr);
        sb.append(", userTel=").append(userTel);
        sb.append(", userQq=").append(userQq);
        sb.append(", userEMail=").append(userEMail);
        sb.append(", ts=").append(ts);
        sb.append(", orgCd=").append(orgCd);
        sb.append(", userSalt=").append(userSalt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 性别枚举
     */
    public enum userSexEnum{

        /**
         * 男
         */
        BOY(1, "男"),
        /**
         * 女
         */
        GIRL(2, "女");

        private Integer value;
        private String descript;

        userSexEnum(Integer value, String descript){
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