package cn.edu.qvtu.util;

/**
 * api接口返回数据模型
 */
public class ApiData {
    private Boolean state;
    private String msg;
    private Object data;

    //getter和setter方法
    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
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

    public void setData(Object data) {
        this.data = data;
    }

    //在构造函数中，初始化数据
    public ApiData(Boolean state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    //编写工厂方法，获得对象

    /**
     * 获得失败的对象
     */
    public static ApiData fail(String msg) {
        return new ApiData(false, msg, null);
    }

    /**
     * 获得成功的对象
     */
    public static ApiData success(Object data, String msg) {
        return new ApiData(true, msg, data);
    }

    public static ApiData success(Object data) {
        return success(data, "请求成功");
    }
}
