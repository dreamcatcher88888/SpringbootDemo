package com.springboot.demo.common.response;

import org.springframework.http.HttpStatus;

public class BaseResponse {
    private int code = HttpStatus.OK.value();
    private String message = HttpStatus.OK.getReasonPhrase();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
