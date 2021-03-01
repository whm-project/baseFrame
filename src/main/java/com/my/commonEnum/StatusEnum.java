package com.my.commonEnum;

/**
 * @author whm
 * @date 2018/7/30
 */
public enum StatusEnum {

    /**
     * 删除
     */
    DELETED(-1, "已删除"),
    /**
     * 停用
     */
    NOUSED(0, "已停用"),
    /**
     * 正常
     */
    USED(1, "正常");

    private Integer value;
    private String descript;

    StatusEnum(Integer value, String descript){
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
