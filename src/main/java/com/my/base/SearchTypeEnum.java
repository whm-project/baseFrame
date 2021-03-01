package com.my.base;

import tk.mybatis.mapper.entity.Example;

/**
 * 查询操作类型枚举
 * @author whm
 * @date 2018/8/14
 */
public enum SearchTypeEnum {

    LIKE("like", "模糊"),
    NOTLIKE("not like", "不匹配"),
    IN("in", "in"),
    NOTIN("nin", "notIn"),
    EQ("eq", "等于"),
    NQ("nq", "不等于"),
    LT("lt", "小于"),
    GT("gt", "大于"),
    LTE("lte", "小于等于"),
    GTE("gte", "大于等于");

    private String value;
    private String descript;

    SearchTypeEnum(String value, String descript){
        this.value = value;
        this.descript = descript;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

}
