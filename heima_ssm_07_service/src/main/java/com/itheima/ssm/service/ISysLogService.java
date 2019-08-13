package com.itheima.ssm.service;

import com.itheima.ssm.SysLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysLogService")
public interface ISysLogService {


    List<SysLog> findAll() throws Exception;

    void save(SysLog sysLog) throws Exception;
}
