package com.springboot.demo.common.Security;

import com.springboot.demo.test.service.IUserManagementService;
import com.springboot.demo.test.vo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailService.class);
    @Resource
    private IUserManagementService userManagementService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        UserInfo user=userManagementService.getUserInfo(username);
        final CustomUserDetail userDetail = new CustomUserDetail(username, user.getPassword(), authorities);
        userDetail.setUser(user);
        return userDetail;
    }
}
