package com.itheima.ssm.service;

import com.com.itheima.ssm.domain.Role;
import com.com.itheima.ssm.domain.UserInfo;

import java.util.List;

/**
 * @program: heima_ssm_07
 * @description:
 * @author: wangenxian
 * @create: 2019-07-18 09:23
 **/
public interface IRoleService {
    List<Role> findAll() throws Exception;

    void save(Role role);

}
