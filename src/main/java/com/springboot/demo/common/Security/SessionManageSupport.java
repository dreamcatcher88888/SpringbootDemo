package com.springboot.demo.common.Security;


import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户session管理类
 */
@Component
public class SessionManageSupport {

    private static SessionRegistry sessionRegistry;

    @Resource
    public void setSessionRegistry(SessionRegistry sessionRegistry) {
        SessionManageSupport.sessionRegistry = sessionRegistry;
    }

    /**
     * 将用户踢下线
     *
     * @param userList
     */
    public void expireUserSession(List<String> userList) {
        if (!CollectionUtils.isEmpty(userList)) {
            for (String user : userList) {
                expireUserSession(user);
            }
        }

    }

    /**
     * 将登录用户踢下线
     *
     * @param userName
     */
    public void expireUserSession(String userName) {
        List<Object> principalList = sessionRegistry.getAllPrincipals();
        for (Object principal : principalList) {
            String user = principal.toString();
            if (user.equals(userName)) {
                List<SessionInformation> sessionInformationList = sessionRegistry.getAllSessions(principal, true);
                if (!CollectionUtils.isEmpty(sessionInformationList)) {
                    for (SessionInformation sessionInformation : sessionInformationList) {
                        sessionInformation.expireNow();
                    }
                }
                break;
            }
        }

    }

    /**
     * 获取当前在线的所有用户
     *
     * @return
     */
    public List<String> findOnlineUser() {
        List<Object> principalList = sessionRegistry.getAllPrincipals();
        List<String> userList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(principalList)) {
            for (Object principal : principalList) {
                List<SessionInformation> informationList = sessionRegistry.getAllSessions(principal, false);
                if (!CollectionUtils.isEmpty(informationList)) {
                    String u = ((CustomUserDetail) informationList.get(0).getPrincipal()).getUser().getUserName();
                    userList.add(u);
                }
            }
        }
        return userList;
    }

    public static int getAllSessionCount() {
        List<Object> principalList = sessionRegistry.getAllPrincipals();
        int count = 0;
        if (!CollectionUtils.isEmpty(principalList)) {
            for (Object principal : principalList) {
                List<SessionInformation> informationList = sessionRegistry.getAllSessions(principal, false);
                count += informationList.size();
            }
        }
        return count;
    }

    public static boolean judgeUserOnline(String userName) {
        List<Object> list = sessionRegistry.getAllPrincipals();
        if (list != null && list.contains(userName)) {
            return true;
        }
        return false;
    }

}
