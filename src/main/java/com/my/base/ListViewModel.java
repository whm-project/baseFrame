package com.my.base;

import java.util.List;

/**
 * 集合返回
 * @author whm
 * @date 2018/6/12
 */
public class ListViewModel<T> {

    private Integer code;

    private long count;

    private List<T> data;

    private String otherData;

    private String msg;

    public ListViewModel(){
    }

    public ListViewModel(Integer code, long total, List<T> data){
        this.code = code;
        this.count = total;
        this.data = data;
    }

    public ListViewModel(Integer code, long total, List<T> data, String otherData, String msg){
        this.code = code;
        this.count = total;
        this.data = data;
        this.otherData = otherData;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getOtherData() {
        return otherData;
    }

    public void setOtherData(String otherData) {
        this.otherData = otherData;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * code枚举
     */
    public enum CodeEnum {

        /**
         * 正常
         */
        NORMAL(0, "正常"),
        /**
         * 异常
         */
        ABNORMAL(1, "异常");

        private Integer value;
        private String descript;

        CodeEnum(Integer value, String descript){
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
