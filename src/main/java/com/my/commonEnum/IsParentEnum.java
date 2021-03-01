package com.my.commonEnum;

/**
 * 是否有子集
 * @author whm
 * @date 2019/1/4
 */
public enum IsParentEnum {

    /**
     * 有子节点
     */
    HASCHILD((short)1, "有子节点"),
    /**
     * 没有子节点
     */
    NOCHILD((short)0, "没有子节点");

    private Short value;
    private String descript;

    IsParentEnum(Short value, String descript){
        this.value = value;
        this.descript = descript;
    }

    public Short getValue() {
        return value;
    }

    public void setValue(Short value) {
        this.value = value;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
