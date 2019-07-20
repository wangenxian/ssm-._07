package com.itheima.ssm.service;


import com.com.itheima.ssm.domain.UserInfo;

import java.util.List;

public interface IUserService  {

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo);
}
