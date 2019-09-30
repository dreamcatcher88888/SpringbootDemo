package com.springboot.demo.common.exception;

import com.springboot.demo.common.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class DemoExceptionHander {

    private final static Logger LOGGER = LoggerFactory.getLogger(DemoExceptionHander.class);

    @ExceptionHandler(DemoException.class)
    public BaseResponse handAgentRuntimeException(DemoException e) {
        LOGGER.warn("", e);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(500);
        baseResponse.setMessage(e.getMessage());
        return baseResponse;
    }


    @ExceptionHandler(Exception.class)
    public BaseResponse handleOtherException(Exception e) {
        LOGGER.error("", e);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(500);
        baseResponse.setMessage("系统内部错误");
        return baseResponse;
    }
}
