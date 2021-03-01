package com.my.frame.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_parameter")
public class SysParameter implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "PARAMETER_ID")
    private Long parameterId;

    /**
     * 参数名称
     */
    @Column(name = "PARAMETER_NM")
    private String parameterNm;

    /**
     * 参数code
     */
    @Column(name = "PARAMETER_CD")
    private String parameterCd;

    /**
     * 参数值
     */
    @Column(name = "PARAMETER_VALUE")
    private String parameterValue;

    /**
     * 备注
     */
    @Column(name = "NT")
    private String nt;

    /**
     * 时间戳
     */
    @Column(name = "TS")
    private Date ts;

    /**
     * 排序值
     */
    @Column(name = "PARAMETER_ORDER")
    private Integer parameterOrder;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return PARAMETER_ID - 主键
     */
    public Long getParameterId() {
        return parameterId;
    }

    /**
     * 设置主键
     *
     * @param parameterId 主键
     */
    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    /**
     * 获取参数名称
     *
     * @return PARAMETER_NM - 参数名称
     */
    public String getParameterNm() {
        return parameterNm;
    }

    /**
     * 设置参数名称
     *
     * @param parameterNm 参数名称
     */
    public void setParameterNm(String parameterNm) {
        this.parameterNm = parameterNm;
    }

    /**
     * 获取参数code
     *
     * @return PARAMETER_CD - 参数code
     */
    public String getParameterCd() {
        return parameterCd;
    }

    /**
     * 设置参数code
     *
     * @param parameterCd 参数code
     */
    public void setParameterCd(String parameterCd) {
        this.parameterCd = parameterCd;
    }

    /**
     * 获取参数值
     *
     * @return PARAMETER_VALUE - 参数值
     */
    public String getParameterValue() {
        return parameterValue;
    }

    /**
     * 设置参数值
     *
     * @param parameterValue 参数值
     */
    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
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
     * @return PARAMETER_ORDER - 排序值
     */
    public Integer getParameterOrder() {
        return parameterOrder;
    }

    /**
     * 设置排序值
     *
     * @param parameterOrder 排序值
     */
    public void setParameterOrder(Integer parameterOrder) {
        this.parameterOrder = parameterOrder;
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
        sb.append(", parameterId=").append(parameterId);
        sb.append(", parameterNm=").append(parameterNm);
        sb.append(", parameterCd=").append(parameterCd);
        sb.append(", parameterValue=").append(parameterValue);
        sb.append(", nt=").append(nt);
        sb.append(", ts=").append(ts);
        sb.append(", parameterOrder=").append(parameterOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}