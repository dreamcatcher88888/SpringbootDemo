package com.springboot.demo.common.Security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class CustomJSONLoginFilter extends AbstractAuthenticationProcessingFilter {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomJSONLoginFilter.class);
    private UserDetailsService userService;
    private SessionRegistry sessionRegistry;

    CustomJSONLoginFilter(String defaultFilterProcessesUrl, UserDetailsService userService, SessionRegistry sessionRegistry) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, HttpMethod.POST.name()));
        this.userService = userService;
        this.sessionRegistry = sessionRegistry;
    }

    public Authentication attemptAuthentication(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws AuthenticationException {
        final JSONObject requestBody = this.getRequestBody(httpServletRequest);
        final String username = requestBody.getString("username");
        final String password = requestBody.getString("password");
        final UserDetails userDetails = this.validateUsernameAndPassword(username, password);
        //密码验证通过后
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        //用户名密码验证通过后,注册session
        httpServletRequest.getSession().setMaxInactiveInterval(30 * 60);
        sessionRegistry.registerNewSession(httpServletRequest.getSession().getId(), authRequest.getPrincipal());
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    private JSONObject getRequestBody(final HttpServletRequest request) throws AuthenticationException {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            InputStream inputStream = request.getInputStream();
            byte[] bs = new byte[4096];
            int len;
            while ((len = inputStream.read(bs)) != -1) {
                stringBuilder.append(new String(bs, 0, len));
            }
            return JSON.parseObject(stringBuilder.toString());
        } catch (IOException e) {
            LOGGER.error("get request body error.", e);
            throw new AuthenticationServiceException("invalid request body");
        }

    }

    private UserDetails validateUsernameAndPassword(final String username, final String password) throws AuthenticationException {
        UserDetails userDO = userService.loadUserByUsername(username);
        if (userDO == null) {
            throw new UsernameNotFoundException("user not exist");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, userDO.getPassword())) {
            throw new AuthenticationServiceException("用户名或密码不正确");
        }
//        if(SessionManageSupport.judgeUserOnline(username)){
//            throw new UsernameNotFoundException("当前用户已在其他电脑登录");
//        }
        return userDO;
    }

}
