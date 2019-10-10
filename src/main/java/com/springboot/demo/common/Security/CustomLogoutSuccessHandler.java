package com.springboot.demo.common.Security;

import com.alibaba.fastjson.JSON;
import com.springboot.demo.common.response.CommonResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
        final CommonResponse<String> baseResponse = (CommonResponse<String>) new CommonResponse();
        baseResponse.setCode(301);
        baseResponse.setResults("/login");
        baseResponse.setMessage("退出成功");
        request.getSession().invalidate();
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        try (PrintWriter out = response.getWriter()) {
            out.write(JSON.toJSONString(baseResponse));
        }
    }
}
