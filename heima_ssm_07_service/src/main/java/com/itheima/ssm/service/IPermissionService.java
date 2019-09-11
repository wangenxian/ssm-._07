package com.itheima.ssm.service;

import com.itheima.ssm.Permission;

import java.util.List;

public interface IPermissionService {

    public List<com.itheima.ssm.Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    com.itheima.ssm.Permission findById(String id) throws Exception;

    void deleteById(String id) throws Exception;
}
