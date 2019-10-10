package com.springboot.demo.test.service;

import com.springboot.demo.test.vo.UserInfo;

public interface IUserManagementService {
    void addUser(UserInfo user);

    UserInfo getUserInfo(String userName);


}
