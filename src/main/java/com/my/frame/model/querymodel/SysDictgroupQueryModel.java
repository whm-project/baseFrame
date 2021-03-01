package com.my.frame.model.querymodel;

import com.my.base.BaseQueryModel;
import java.io.Serializable;
import java.util.Date;

public class SysDictgroupQueryModel extends BaseQueryModel implements Serializable {
    /**
     * 主键
     * 
     * @mbg.generated
     */
    private Long dictgroupId;

    /**
     * 类型代码
     * 
     * @mbg.generated
     */
    private String dictgroupCd;

    /**
     * 类型名称
     * 
     * @mbg.generated
     */
    private String dictgroupNm;

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
     * 排序值
     * 
     * @mbg.generated
     */
    private Integer dictgroupOrder;

    private String dictgroupOther1;

    private String dictgroupOther2;

    private String dictgroupOther3;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return DICTGROUP_ID - 主键
     */
    public Long getDictgroupId() {
        return dictgroupId;
    }

    /**
     * 设置主键
     *
     * @param dictgroupId 主键
     */
    public void setDictgroupId(Long dictgroupId) {
        this.dictgroupId = dictgroupId;
    }

    /**
     * 获取类型代码
     *
     * @return DICTGROUP_CD - 类型代码
     */
    public String getDictgroupCd() {
        return dictgroupCd;
    }

    /**
     * 设置类型代码
     *
     * @param dictgroupCd 类型代码
     */
    public void setDictgroupCd(String dictgroupCd) {
        this.dictgroupCd = dictgroupCd;
    }

    /**
     * 获取类型名称
     *
     * @return DICTGROUP_NM - 类型名称
     */
    public String getDictgroupNm() {
        return dictgroupNm;
    }

    /**
     * 设置类型名称
     *
     * @param dictgroupNm 类型名称
     */
    public void setDictgroupNm(String dictgroupNm) {
        this.dictgroupNm = dictgroupNm;
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
     * 获取排序值
     *
     * @return DICTGROUP_ORDER - 排序值
     */
    public Integer getDictgroupOrder() {
        return dictgroupOrder;
    }

    /**
     * 设置排序值
     *
     * @param dictgroupOrder 排序值
     */
    public void setDictgroupOrder(Integer dictgroupOrder) {
        this.dictgroupOrder = dictgroupOrder;
    }

    /**
     * @return DICTGROUP_OTHER1
     */
    public String getDictgroupOther1() {
        return dictgroupOther1;
    }

    /**
     * @param dictgroupOther1
     */
    public void setDictgroupOther1(String dictgroupOther1) {
        this.dictgroupOther1 = dictgroupOther1;
    }

    /**
     * @return DICTGROUP_OTHER2
     */
    public String getDictgroupOther2() {
        return dictgroupOther2;
    }

    /**
     * @param dictgroupOther2
     */
    public void setDictgroupOther2(String dictgroupOther2) {
        this.dictgroupOther2 = dictgroupOther2;
    }

    /**
     * @return DICTGROUP_OTHER3
     */
    public String getDictgroupOther3() {
        return dictgroupOther3;
    }

    /**
     * @param dictgroupOther3
     */
    public void setDictgroupOther3(String dictgroupOther3) {
        this.dictgroupOther3 = dictgroupOther3;
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
        sb.append(", dictgroupId=").append(dictgroupId);
        sb.append(", dictgroupCd=").append(dictgroupCd);
        sb.append(", dictgroupNm=").append(dictgroupNm);
        sb.append(", ts=").append(ts);
        sb.append(", nt=").append(nt);
        sb.append(", dictgroupOrder=").append(dictgroupOrder);
        sb.append(", dictgroupOther1=").append(dictgroupOther1);
        sb.append(", dictgroupOther2=").append(dictgroupOther2);
        sb.append(", dictgroupOther3=").append(dictgroupOther3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}