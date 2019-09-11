package com.itheima.ssm.service;

import com.itheima.ssm.Permission;
import com.itheima.ssm.Role;

import java.util.List;

/**
 * @program: heima_ssm_07
 * @description:
 * @author: wangenxian
 * @create: 2019-07-18 09:23
 **/
public interface IRoleService {
    List<com.itheima.ssm.Role> findAll() throws Exception;

    void save(Role role);

    com.itheima.ssm.Role findById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);

}
