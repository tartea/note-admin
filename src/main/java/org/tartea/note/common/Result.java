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
        this.code = BaseApiCode.SUCCESS.getCode();
        return this;
    }
    public Result<T> fail() {
        this.code = BaseApiCode.FAIL.getCode();
        this.success = false;
        this.code = BaseApiCode.FAIL.getCode();
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
