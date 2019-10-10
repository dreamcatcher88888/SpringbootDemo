package com.springboot.demo.common.Security;

import com.alibaba.fastjson.JSON;
import com.springboot.demo.common.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        final BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(HttpStatus.FORBIDDEN.value());
        baseResponse.setMessage("拒绝访问");
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        try (final PrintWriter out = httpServletResponse.getWriter()) {
            out.write(JSON.toJSONString(baseResponse));
        }
    }
}
