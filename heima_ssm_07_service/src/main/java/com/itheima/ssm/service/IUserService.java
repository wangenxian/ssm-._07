package com.itheima.ssm.service;


import com.itheima.ssm.Orders;
import com.itheima.ssm.Role;
import com.itheima.ssm.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll(int page, int size) throws Exception;

    void save(UserInfo userInfo);

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds);

    void deleteById(String id);

    Orders findOrders(int id);


    int findOrderId(String id);

    void updateById(String userId,UserInfo userInfo);
}
