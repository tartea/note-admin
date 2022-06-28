package org.tartea.note.common;

public enum CosUsedEnum {
    NOT_USED(0,"未使用"),
    USED(1,"使用");

    private Integer code;

    private String msg;

    CosUsedEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
