package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.Orders;
import com.itheima.ssm.Role;
import com.itheima.ssm.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 *  @program: heima_ssm_07
 * @description:
 * @author: wangenxian
 * @create: 2019-07-17 17:16
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired

    private IUserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "3") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> users = userService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(users);
        mv.addObject("pageInfo", pageInfo);
        System.out.println("findAll.do方法执行了");
        mv.setViewName("user-list");
        return mv;

    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) {
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;

        //
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findById(id);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(id);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add1");

        return mv;

    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) {
        userService.addRoleToUser(userId, roleIds);

        return "redirect:findAll";
    }

    @RequestMapping("/deleteById")

    public String deleteById(@RequestParam(name = "id", required = true) String id) {

        int orderId = userService.findOrderId(id);
        Orders orders = userService.findOrders(orderId);
        if (orders == null) {
            userService.deleteById(id);
            return "redirect:findAll";

        } else
            return "error";
    }

    @RequestMapping("/updateById")
    public String updateById(@RequestParam(name = "id", required = true) String userId, UserInfo userInfo) {
        userService.updateById(userId, userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findUserById")
    public ModelAndView findUserById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("userInfo", userInfo);
        mv.setViewName("user-show2");
        return mv;
    }
}

