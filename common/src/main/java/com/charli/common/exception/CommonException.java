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
        this(message,false);
        this.code = StatusCodeEnum.INVALID_REQUEST.getKey();
    }

    public CommonException(Integer code, String message) {
        this(message,false);
        this.code = code;
    }

    public CommonException(StatusCodeEnum statusCodeEnum) {
        this(statusCodeEnum.getValue(),false);
        this.code = statusCodeEnum.getKey();
    }

    /**
     * @param message 错误信息
     * @param cause   致此异常发生的父异常，即追踪信息里的caused by
     */
    public CommonException(String message, Throwable cause) {
        super(message, cause, false, true);
        this.code = StatusCodeEnum.INVALID_REQUEST.getKey();
    }

    /**
     * enableSuppress:关于异常挂起的参数，设为false即可
     *
     * @param message            错误信息
     * @param writableStackTrace 表示是否生成栈追踪信息，只要将此参数设为false, 则在构造异常对象时就不会调用fillInStackTrace()
     */
    public CommonException(String message, boolean writableStackTrace) {
        super(message, null, false, writableStackTrace);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
