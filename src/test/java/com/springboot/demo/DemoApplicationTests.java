package com.springboot.demo;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.common.pagination.Pagination;
import com.springboot.demo.test.service.ILogManagementService;
import com.springboot.demo.test.vo.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    private final static Logger LOGGER = LoggerFactory.getLogger(DemoApplicationTests.class);
    @Resource
    private ILogManagementService logManagementService;
    @Test
    public void test_getLogList() {
        Log log = new Log();
        Pagination<Log> pagination = new Pagination<>(1, 10, log);
        PageInfo pageInfo = logManagementService.getLogList(pagination);
        LOGGER.info("total:" + pageInfo.getTotal());
    }

}
