package com.springboot.demo.common.Security;

import com.alibaba.fastjson.JSON;
import com.springboot.demo.common.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);

    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(500);
        baseResponse.setMessage(e.getMessage());
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        try (PrintWriter out = httpServletResponse.getWriter()) {
            out.write(JSON.toJSONString(baseResponse));
        }
    }
}
