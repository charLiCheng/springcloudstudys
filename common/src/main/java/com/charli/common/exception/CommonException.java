package com.charli.common.exception;

import com.charli.common.enums.StatusCodeEnum;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/11/8 11:02
 */
public class CommonException extends RuntimeException {
    private Integer code;

    public CommonException(String message) {
        super(message);
        this.code = StatusCodeEnum.INTERNAL_SERVER_ERROR.getKey();
    }

    public CommonException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CommonException(StatusCodeEnum statusCodeEnum) {
        super(statusCodeEnum.getValue());
        this.code = statusCodeEnum.getKey();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
