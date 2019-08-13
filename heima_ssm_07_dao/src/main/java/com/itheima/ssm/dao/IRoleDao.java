package com.itheima.ssm.dao;


import com.com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @program: heima_ssm_07
 * @description:
 * @author: wangenxian
 * @create: 2019-07-18 09:27
 **/


public interface IRoleDao {

    //根据用户id查询出所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;
    @Select("select * from role")
    List<Role> findAll() throws Exception;
    @Insert("insert into role (id, roleName, roleDesc) VALUES (#{id},#{roleName},#{roleDesc})")
    void save(Role role);


}
