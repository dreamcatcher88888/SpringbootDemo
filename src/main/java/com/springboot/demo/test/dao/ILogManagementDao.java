package com.springboot.demo.test.dao;

import com.springboot.demo.test.vo.Log;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface ILogManagementDao {
    List<Log> getLogList(Log param);
}
