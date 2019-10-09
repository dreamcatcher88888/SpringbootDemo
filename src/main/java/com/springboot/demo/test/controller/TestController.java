package com.springboot.demo.test.controller;


import com.github.pagehelper.PageInfo;
import com.springboot.demo.common.pagination.Pagination;
import com.springboot.demo.common.response.BaseResponse;
import com.springboot.demo.common.response.CommonResponse;
import com.springboot.demo.test.vo.Log;
import com.springboot.demo.test.service.ILogManagementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/log")
@RestController
public class TestController {

    @Resource
    ILogManagementService logManagementService;

    @RequestMapping("/list")
    public BaseResponse getLogList(@RequestParam(defaultValue = "1", required = false) int pageNo,
                                   @RequestParam(defaultValue = "20", required = false) int pageSize, Log log) {
        Pagination<Log> pagination = new Pagination<>(pageNo, pageSize, log);
        PageInfo pageInfo = logManagementService.getLogList(pagination);
        CommonResponse<PageInfo> commonResponse = new CommonResponse<>();
        commonResponse.setResults(pageInfo);
        return commonResponse;
    }

}
