package com.itheima.ssm.controller;


import com.com.itheima.ssm.domain.Role;
import com.com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @program: heima_ssm_07
 * @description:
 * @author: wangenxian
 * @create: 2019-07-18 09:22
 **/

@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
         System.out.println("角色方法执行了");
         ModelAndView mv = new ModelAndView();
         List<Role> roles = roleService.findAll();
         mv.addObject("roleList",roles);
         mv.setViewName("role-list");
         return  mv;

    }
    @RequestMapping("/save")
    public  String save(Role role) throws  Exception{
            roleService.save(role);
            return "redirect:findAll";

    }

}
