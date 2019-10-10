package com.springboot.demo.common.Security;

import com.alibaba.fastjson.JSON;
import com.springboot.demo.common.response.BaseResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        //添加日志
        final BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("登录成功");
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        try (PrintWriter out = httpServletResponse.getWriter()) {
            out.write(JSON.toJSONString(baseResponse));
        }
    }
}
