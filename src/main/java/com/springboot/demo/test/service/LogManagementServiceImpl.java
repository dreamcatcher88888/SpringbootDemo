package com.springboot.demo.test.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.demo.common.pagination.Pagination;
import com.springboot.demo.test.dao.ILogManagementDao;
import com.springboot.demo.test.vo.Log;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogManagementServiceImpl implements ILogManagementService {

    @Resource
    ILogManagementDao logManagementDao;

    @Override
    public PageInfo getLogList(Pagination<Log> log) {
        PageHelper.startPage(log.getPageNo(), log.getPageSize());
        List<Log> logList = logManagementDao.getLogList(log.getParam());
        PageInfo pageInfo = new PageInfo(logList);
        pageInfo.setList(logList);
        return pageInfo;
    }


}
