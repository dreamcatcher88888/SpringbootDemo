package com.springboot.demo.common.Security;

import com.alibaba.fastjson.*;
import com.springboot.demo.common.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.*;
import org.springframework.security.web.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authenticationEx) throws IOException {
        final BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(HttpStatus.UNAUTHORIZED.value());
        baseResponse.setMessage("未登录");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        httpServletResponse.setStatus(200);
        try (final PrintWriter out = httpServletResponse.getWriter()) {
            out.append(JSON.toJSONString(baseResponse));
        }
    }
}
