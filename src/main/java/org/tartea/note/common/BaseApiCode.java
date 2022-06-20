package org.tartea.note.common;

public enum BaseApiCode {

    SUCCESS(0, "操作成功"),
    FAIL(-1, "操作失败"),
    BUSINESS_ERROR(1000, "业务异常"),
    UNLAW_REQUEST(1001, "非法请求");

    private int code;

    private String msg;

    BaseApiCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
