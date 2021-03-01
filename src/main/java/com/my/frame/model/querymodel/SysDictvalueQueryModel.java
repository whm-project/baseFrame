package com.my.frame.model.querymodel;

import com.my.base.BaseQueryModel;
import java.io.Serializable;
import java.util.Date;

public class SysDictvalueQueryModel extends BaseQueryModel implements Serializable {
    /**
     * 主键
     * 
     * @mbg.generated
     */
    private String dictvalueId;

    /**
     * 类型代码
     * 
     * @mbg.generated
     */
    private String dictgroupCd;

    /**
     * 类型值
     * 
     * @mbg.generated
     */
    private String dictvalueValue;

    /**
     * 值含义
     * 
     * @mbg.generated
     */
    private String dictvalueMean;

    /**
     * 备注
     * 
     * @mbg.generated
     */
    private String nt;

    /**
     * 时间戳
     * 
     * @mbg.generated
     */
    private Date ts;

    /**
     * 排序值
     * 
     * @mbg.generated
     */
    private Integer dictvalueOrder;

    private String dictvalueOther1;

    private String dictvalueOther2;

    private String dictvalueOther3;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return DICTVALUE_ID - 主键
     */
    public String getDictvalueId() {
        return dictvalueId;
    }

    /**
     * 设置主键
     *
     * @param dictvalueId 主键
     */
    public void setDictvalueId(String dictvalueId) {
        this.dictvalueId = dictvalueId;
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
     * 获取类型值
     *
     * @return DICTVALUE_VALUE - 类型值
     */
    public String getDictvalueValue() {
        return dictvalueValue;
    }

    /**
     * 设置类型值
     *
     * @param dictvalueValue 类型值
     */
    public void setDictvalueValue(String dictvalueValue) {
        this.dictvalueValue = dictvalueValue;
    }

    /**
     * 获取值含义
     *
     * @return DICTVALUE_MEAN - 值含义
     */
    public String getDictvalueMean() {
        return dictvalueMean;
    }

    /**
     * 设置值含义
     *
     * @param dictvalueMean 值含义
     */
    public void setDictvalueMean(String dictvalueMean) {
        this.dictvalueMean = dictvalueMean;
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
     * 获取排序值
     *
     * @return DICTVALUE_ORDER - 排序值
     */
    public Integer getDictvalueOrder() {
        return dictvalueOrder;
    }

    /**
     * 设置排序值
     *
     * @param dictvalueOrder 排序值
     */
    public void setDictvalueOrder(Integer dictvalueOrder) {
        this.dictvalueOrder = dictvalueOrder;
    }

    /**
     * @return DICTVALUE_OTHER1
     */
    public String getDictvalueOther1() {
        return dictvalueOther1;
    }

    /**
     * @param dictvalueOther1
     */
    public void setDictvalueOther1(String dictvalueOther1) {
        this.dictvalueOther1 = dictvalueOther1;
    }

    /**
     * @return DICTVALUE_OTHER2
     */
    public String getDictvalueOther2() {
        return dictvalueOther2;
    }

    /**
     * @param dictvalueOther2
     */
    public void setDictvalueOther2(String dictvalueOther2) {
        this.dictvalueOther2 = dictvalueOther2;
    }

    /**
     * @return DICTVALUE_OTHER3
     */
    public String getDictvalueOther3() {
        return dictvalueOther3;
    }

    /**
     * @param dictvalueOther3
     */
    public void setDictvalueOther3(String dictvalueOther3) {
        this.dictvalueOther3 = dictvalueOther3;
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
        sb.append(", dictvalueId=").append(dictvalueId);
        sb.append(", dictgroupCd=").append(dictgroupCd);
        sb.append(", dictvalueValue=").append(dictvalueValue);
        sb.append(", dictvalueMean=").append(dictvalueMean);
        sb.append(", nt=").append(nt);
        sb.append(", ts=").append(ts);
        sb.append(", dictvalueOrder=").append(dictvalueOrder);
        sb.append(", dictvalueOther1=").append(dictvalueOther1);
        sb.append(", dictvalueOther2=").append(dictvalueOther2);
        sb.append(", dictvalueOther3=").append(dictvalueOther3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}