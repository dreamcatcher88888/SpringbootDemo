package com.springboot.demo.test.controller;

import com.springboot.demo.common.response.BaseResponse;
import com.springboot.demo.test.service.IUserManagementService;
import com.springboot.demo.test.vo.UserInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户角色权限管理
 */
@RestController
@RequestMapping("/user")
public class UserManagementController {

    @Resource
    private IUserManagementService userManagementService;

    /**
     * 添加用户
     *
     * @return
     */
    @RequestMapping("/addUser")
    public BaseResponse addUser(UserInfo user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode("xxx@123"));
        userManagementService.addUser(user);
        return new BaseResponse();
    }
}
