package com.itheima.ssm.controller;

import com.com.itheima.ssm.domain.Orders;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;
//    @RequestMapping("/findAll")
//    public ModelAndView findAll(  ) throws Exception {
//        System.out.println("orderFindll   controller方法执行了");
//        ModelAndView mv = new ModelAndView();
//        List<Orders> ordersList = ordersService.findAll();
//        System.out.println("orderFindll方法完成了");
//        //PageInfo就是一个分页Bean
//        mv.addObject("ordersList", ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }
    @RequestMapping("/findAll")
    //默认查的页码.
    public ModelAndView findAll(
            ) throws Exception {
        System.out.println("orderFindll方法指向了");
//        ModelAndView mv = new ModelAndView();
//        List<Orders> ordersList = ordersService.findAll(1, 4);
//        System.out.println("orderFindll方法完成了");
//        //PageInfo就是一个分页Bean
//        PageInfo pageInfo = new PageInfo(ordersList);
//        mv.addObject("pageInfo", pageInfo);
//        mv.setViewName("orders-page-list");
        List<Orders> ordersList = ordersService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("ordersList", ordersList);
        mv.setViewName("orders-list");
        return mv;

    }


}
