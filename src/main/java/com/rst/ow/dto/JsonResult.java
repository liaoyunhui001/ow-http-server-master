package com.rst.ow.dto;

/**
 * Created by hujia on 2016/11/16.
 */
public class JsonResult<T> {
    private T data;
    private boolean success = true;
    private String msg = "";

    public JsonResult() {

    }

    public JsonResult(String msg) {
        this.success = false;
        this.msg = msg;
        this.data = null;
    }

    public JsonResult(T data) {
        this.success = true;
        this.msg = "";
        this.data = data;
    }

    public JsonResult(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonResult:\n{\n\tsuccess:" + success +
                ",\n\tmsg:" + msg +
                "\n\tdata:" + data +
                "\n}";
    }
}
