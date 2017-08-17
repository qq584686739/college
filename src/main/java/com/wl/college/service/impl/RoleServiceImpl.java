package com.wl.college.service.impl;

import com.wl.college.dao.RoleDao;
import com.wl.college.entity.Role;
import com.wl.college.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 返回所有的role
     * @return List<Role>
     */
    @Override
    public List<Role> listAll() {
        return roleDao.findAll();
    }

    /**
     * 创建一个role并分配权限
     * @param role
     * @param permissions
     */
    @Override
    public void createRole(Role role, List<Integer> permissions) {
        roleDao.createRole(role);
        if(permissions!=null && permissions.size()>0){
            roleDao.createRolePermission(role.getId(), permissions);
        }
    }
}
