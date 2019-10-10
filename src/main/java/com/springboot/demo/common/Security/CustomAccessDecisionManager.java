package com.springboot.demo.common.Security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {
    public static final String COMMA = ",";

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection)
            throws AccessDeniedException, InsufficientAuthenticationException {
        // 匿名用户
        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new BadCredentialsException("未登录");
        } else {
            // 登录成功后,获取当前用户角色可以访问的url集合
//            List<String> accessibleUrlsList = ((CustomUserDetail) authentication.getPrincipal()).getUser().getUrls();
//            if (!isAccessable(o, accessibleUrlsList)) {
//                throw new AccessDeniedException("没有操作权限");
//            }
        }
    }

    private boolean isAccessable(Object o, List<String> accessibleUrlsList) {
        //TODO 开发阶段，都有访问权限
        return true;
//        String requestUrl = o.toString();
//        if (null != accessibleUrlsList && accessibleUrlsList.size() > 0) {
//            for (int i = 0; i < accessibleUrlsList.size(); i++) {
//                //数据库配置的url形式，一个菜单id可能对应多个Url，多个url支持通配符如/xxxx/**,多个url之间用,号分隔
//                String accessibleUrl = accessibleUrlsList.get(i);
//                String accessibleUrlArray[] = accessibleUrl.split(COMMA);
//                for (String url : accessibleUrlArray) {
//                    if (url.contains("**")) {
//                        url = url.replace("**", "");
//                    }
//                    if (requestUrl.contains(url)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
