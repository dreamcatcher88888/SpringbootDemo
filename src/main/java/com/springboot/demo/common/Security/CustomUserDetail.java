package com.springboot.demo.common.Security;

import com.springboot.demo.test.vo.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 用户详细信息类
 */
public class CustomUserDetail extends User {

    private UserInfo user;

    public CustomUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    /**
     * 重写比较方法,SpringSecurity根据用户名来比较是否同一个用户
     */
    @Override
    public boolean equals(Object o) {
        if (o.toString().equals(getUsername()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return getUsername().hashCode();
    }


    @Override
    public String toString() {
        return getUsername();
    }
}
