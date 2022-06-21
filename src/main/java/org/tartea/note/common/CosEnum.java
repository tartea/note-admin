package org.tartea.note.common;

public enum CosEnum {

    tencent("tencent","腾讯云cos配置");

    private String code;

    private String msg;

    CosEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
