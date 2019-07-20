package com.itheima.ssm.service.impl;

import com.com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;




@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Override
//    public UserDetails loadUserByUsername(String us
//                                          erName) throws UsernameNotFoundException {
//        UserInfo userInfo =null;
//        try {
//            userInfo = userDao.findByUsername(userName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        };
//       User user = new User(userInfo.getUsername(),userInfo.getPassword(),getGrantedAuthority());
//        return user;
//    }
//    public List<SimpleGrantedAuthority> getGrantedAuthority(){
//        List<SimpleGrantedAuthority> list = new ArrayList<>();
//        list.add(new SimpleGrantedAuthority("ROLE_USER")) ;
//        return  list;
//
//    }
//
    @Override
    public List<UserInfo> findAll() throws Exception {
       return  userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
//     userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
     userDao.save(userInfo);
     System.out.println(userInfo.getPassword());
    }

}

