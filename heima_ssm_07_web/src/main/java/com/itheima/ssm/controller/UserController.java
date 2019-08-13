package com.itheima.ssm.controller;

import com.com.itheima.ssm.domain.Role;
import com.com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: heima_ssm_07
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
    public ModelAndView findAll() throws Exception {
            System.out.println("方法准备执行了");
            ModelAndView mv = new ModelAndView();
            List<UserInfo> users = userService.findAll();
            mv.addObject("userList",users);
            System.out.println("方法预备执行了");
            mv.setViewName("user-list");
            System.out.println("方法已经执行了");
            return mv;

    }
    @RequestMapping("/save")
    public String save(UserInfo userInfo){
          userService.save(userInfo);
          return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show1");
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
      //  List<Role> otherRoles = userService.findOtherRoles(id);
        mv.addObject("user", userInfo);
//        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }
}

