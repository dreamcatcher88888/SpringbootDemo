package com.springboot.demo.test.service;

import com.springboot.demo.test.dao.IUserManagementDao;
import com.springboot.demo.test.vo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserManagementServiceImpl implements IUserManagementService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserManagementServiceImpl.class);
    @Resource
    private IUserManagementDao userManagementDao;
    @Override
    public void addUser(UserInfo user) {
        //TODO 添加用户
    }

    @Override
    public UserInfo getUserInfo(String userName) {
        //TODO 查询数据库获取用户信息
        UserInfo user=new UserInfo();
        user.setUserId("001");
        user.setPassword("DdQtAkupU5ZGgn2Dg9GCCE/18bJJAl3FGF/7BK3dbAw=");
        return user;
    }


}
