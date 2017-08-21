package com.wl.college.service.impl;

import com.wl.college.dao.RoleDao;
import com.wl.college.entity.Permission;
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

    /**
     * 更新一个role和role_permission
     * @param role
     * @param permissionsList
     */
    @Override
    public void updateRole(Role role, List<Integer> permissionsList) {
        roleDao.updateRole(role);
        if(permissionsList!=null && permissionsList.size()>0){
            roleDao.deleteRolePermission(role.getId());
            roleDao.createRolePermission(role.getId(), permissionsList);
        }
    }

    /**
     * 根据id获得Role
     * @param id
     * @return
     */
    @Override
    public Role getOne(Integer id) {
        return roleDao.getOne(id);
    }

    /**
     * 删除role
     * @param id
     */
    @Override
    public void deleteRole(Integer id) {
        roleDao.deleteRole(id);
    }

    /**
     * 根据role的id获得这个id下的所有permissions
     * @param id
     */
    @Override
    public List<Permission> getPermissionByRoleId(Integer id) {
        return roleDao.getPermissionByRoleId(id);
    }
}
