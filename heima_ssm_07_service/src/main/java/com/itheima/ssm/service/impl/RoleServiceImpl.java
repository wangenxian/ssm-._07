package com.itheima.ssm.service.impl;

import com.itheima.ssm.Permission;
import com.itheima.ssm.Role;
import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<com.itheima.ssm.Role> findAll() throws Exception {
        return roleDao.findAll();

    }

    @Override
    public com.itheima.ssm.Role findById(String roleId) {
        return roleDao.findById(roleId);
    }
    
    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

}
