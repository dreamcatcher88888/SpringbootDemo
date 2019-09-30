package com.springboot.demo.test.service;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.common.pagination.Pagination;
import com.springboot.demo.test.vo.Log;


public interface ILogManagementService {

    PageInfo getLogList(Pagination<Log> pagination);

}
