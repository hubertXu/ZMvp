package com.hubert.xu.zmvp.http;

import java.io.Serializable;

/**
 * Author: Hubert.Xu
 * Date  : 2017/7/14
 * Desc  :
 */

public class HttpResult<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "HttpResult{" +
                "msg='" + msg + '\'' +
                ", state=" + code +
                ", result=" + data +
                '}';
    }
}
