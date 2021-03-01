package com.my.base;

/**
 * 提交返回信息
 * @author whm
 * @date 2018/6/12
 */
public class ResultViewModel {

    private Integer state;

    private String msg;

    private Object data;

    public ResultViewModel(){

    }

    public ResultViewModel(Integer state){
        this.state = state;
    }

    public ResultViewModel(Integer state, String msg){
        this.state = state;
        this.msg = msg;
    }

    public ResultViewModel(Integer state, String msg, Object data){
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public enum StateEnum {

        /**
         * 正常
         */
        NORMAL(1, "正常"),
        /**
         * 异常
         */
        ABNORMAL(0, "异常");

        private Integer value;
        private String descript;

        StateEnum(Integer value, String descript){
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
