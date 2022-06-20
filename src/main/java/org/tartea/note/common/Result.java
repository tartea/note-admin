package org.tartea.note.common;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private boolean success;

    private String msg;

    private T data;


    public Result() {
    }

    public Result<T> success() {
        this.code = BaseApiCode.SUCCESS.getCode();
        this.success = true;
        this.msg = BaseApiCode.SUCCESS.getMsg();
        return this;
    }
    public Result<T> success(T data) {
        this.code = BaseApiCode.SUCCESS.getCode();
        this.success = true;
        this.msg = BaseApiCode.SUCCESS.getMsg();
        this.data = data;
        return this;
    }
    public Result<T> fail() {
        this.code = BaseApiCode.FAIL.getCode();
        this.success = false;
        this.msg = BaseApiCode.FAIL.getMsg();
        return this;
    }
    public Result<T> fail(int code,String msg) {
        this.code = code;
        this.success = false;
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
