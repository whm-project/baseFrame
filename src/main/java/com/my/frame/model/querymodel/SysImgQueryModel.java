package com.my.frame.model.querymodel;

import com.my.base.BaseQueryModel;
import java.io.Serializable;
import java.util.Date;

public class SysImgQueryModel extends BaseQueryModel implements Serializable {
    private Long imgId;

    /**
     * 图片类型
     * 
     * @mbg.generated
     */
    private Integer imgType;

    /**
     * 描述
     * 
     * @mbg.generated
     */
    private String imgRemarks;

    /**
     * 图片地址
     * 
     * @mbg.generated
     */
    private String imgUrl;

    /**
     * 时间戳
     * 
     * @mbg.generated
     */
    private Date ts;

    /**
     * 组织机构代码
     * 
     * @mbg.generated
     */
    private String orgCd;

    /**
     * 图片名称
     */
    private String imgName;

    private static final long serialVersionUID = 1L;

    /**
     * @return IMG_ID
     */
    public Long getImgId() {
        return imgId;
    }

    /**
     * @param imgId
     */
    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    /**
     * 获取图片类型
     *
     * @return IMG_TYPE - 图片类型
     */
    public Integer getImgType() {
        return imgType;
    }

    /**
     * 设置图片类型
     *
     * @param imgType 图片类型
     */
    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }

    /**
     * 获取描述
     *
     * @return IMG_REMARKS - 描述
     */
    public String getImgRemarks() {
        return imgRemarks;
    }

    /**
     * 设置描述
     *
     * @param imgRemarks 描述
     */
    public void setImgRemarks(String imgRemarks) {
        this.imgRemarks = imgRemarks;
    }

    /**
     * 获取图片地址
     *
     * @return IMG_URL - 图片地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imgUrl 图片地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
     * 获取图片名称
     *
     * @return IMG_NAME - 图片名称
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * 设置图片名称
     *
     * @param imgName 图片名称
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
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
        sb.append(", imgId=").append(imgId);
        sb.append(", imgType=").append(imgType);
        sb.append(", imgRemarks=").append(imgRemarks);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", ts=").append(ts);
        sb.append(", orgCd=").append(orgCd);
        sb.append(", imgName=").append(imgName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}