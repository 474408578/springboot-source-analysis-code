package com.kancloud.springboot.launch.core.utils.result;

/**
 * @author xschen
 */

public enum ResultEnum {
    SUCCESS(200, true, "success"),
    BAD_REQUEST(400, false, "bad Request"),
    SERVER_ERROR(500, false, "server error"),
    UNKNOWN_ERROR(-1, false, "unknown error"),
    ;

    private Integer code;
    private Boolean success;
    private String msg;

    ResultEnum(Integer code, Boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }
}
