package com.chuan.rxjavaandretrofit.bean.base;

/**
 * Created by admin on 2017/3/2.
 */

public class BaseResponse<T> extends BaseBean{
    private int retCode;
    private String msg;
    private T data;

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
