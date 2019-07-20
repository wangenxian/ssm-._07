package com.itheima.ssm.dao;


import com.com.itheima.ssm.domain.Role;
import com.com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.List;


/**
 * @program: heima_ssm_07
 * @description:
 * @author: wangenxian
 * @create: 2019-07-18 09:27
 **/


public interface IRoleDao {

    @Select("select * from role")
    List<Role> findAll() throws Exception;
    @Insert("insert into role (id, roleName, roleDesc) VALUES (#{id},#{roleName}),#{roleName})")
    void save(Role role);

}
