package com.itheima.ssm.controller;

import com.itheima.ssm.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        System.out.println("切面方法执行了");
        ModelAndView mv=new ModelAndView();
       List<SysLog> sysLogList= sysLogService.findAll();
       mv.addObject("sysLogs",sysLogList);
       mv.setViewName("syslog-list");
        return mv;
    }
}
