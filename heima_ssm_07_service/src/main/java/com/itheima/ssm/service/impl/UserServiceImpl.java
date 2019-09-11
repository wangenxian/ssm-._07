package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.Orders;
import com.itheima.ssm.Role;
import com.itheima.ssm.UserInfo;
import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    //当返回了一个UserDetails后,框架底层会校对数据.
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(userName);
        } catch (Exception e) {
            e.printStackTrace();
        };
         User user = new User(userInfo.getUsername(),userInfo.getPassword(),getGrantedAuthority());

        return user;
    }
    public List<SimpleGrantedAuthority> getGrantedAuthority(){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER")) ;
        return  list;
        //核心是自己去看代码，然后研究
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return  userDao.findById(id);
    }

    @Override
    public List<UserInfo> findAll(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return  userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
    userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
     userDao.save(userInfo);
     System.out.println(userInfo.getPassword());
    }

    @Override
    public List<Role> findOtherRoles(String userId) {
        return userDao.findOtherRoles(userId);
    }


    @Override
    public void addRoleToUser(String userId, String[] roleIds) {

        for ( String roleId: roleIds) {
            userDao.addRoleToUser(userId , roleId);
        }
    }

    @Override
    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    @Override
    public Orders findOrders(int id) {
        return userDao.findOrders(id);
    }
    @Override
    public int findOrderId(String id){
        return userDao.findOrderId(id);
    }

    @Override
    public void updateById(String userId,UserInfo userInfo) {
        System.out.println("impl方法执行了");
        userDao.updateById(userId,userInfo);
    }
}

