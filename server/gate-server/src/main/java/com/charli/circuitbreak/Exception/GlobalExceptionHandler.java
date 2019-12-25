package com.charli.circuitbreak.Exception;

import com.charli.common.enums.StatusCodeEnum;
import com.charli.common.exception.CommonException;
import com.charli.common.response.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description : 全局异常处理器
 * @Author xiaoli.cheng
 * @Date 2019/12/25 15:19
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 自定义公共异常处理
     *
     * @param commonException
     * @return
     */
    @ExceptionHandler(value = CommonException.class)
    @ResponseBody
    public CommonResponse commonExceptionHandler(CommonException commonException) {
        return CommonResponse.failure(commonException.getCode(), commonException.getMessage());
    }

    /**
     * 其他异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResponse exceptionGet(Exception e) {
        LOGGER.error("【系统异常】: {}", e);
        return CommonResponse.failure(StatusCodeEnum.INTERNAL_SERVER_ERROR);
    }
}
