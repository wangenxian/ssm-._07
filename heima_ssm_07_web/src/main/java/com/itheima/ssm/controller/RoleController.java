package com.itheima.ssm.controller;


import com.itheima.ssm.Permission;
import com.itheima.ssm.Role;
import com.itheima.ssm.service.IRoleService;
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
    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据roleId查询role
        Role role = roleService.findById(roleId);
        //根据roleId查询可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;

    }

    @RequestMapping("/findById")
    public ModelAndView  findById(@RequestParam(name = "id",required = true) String roleId) {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return  mv;
    }
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole( @RequestParam(name = "roleId",required =  true)String roleId,@RequestParam(name = "ids",required = true)String[] permissionIds ){
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll";
    }
}
