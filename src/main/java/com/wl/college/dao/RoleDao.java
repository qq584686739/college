package com.wl.college.dao;


import com.wl.college.entity.Permission;
import com.wl.college.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    /**
     * 找到系统所有角色
     *
     * @return
     */
    List<Role> findAll();

    /**
     * 创建一个角色
     *
     * @param role
     * @return int
     */
    void createRole(@Param("role") Role role);

    /**
     * 创建role_permission
     * @param id
     * @param permissions
     */
    void createRolePermission(@Param("id")Integer id, @Param("permissions")List<Integer> permissions);

    /**
     * 修改一个role
     * @param role
     */
    void updateRole(@Param("role")Role role);

    /**
     * 删除role_permission
     * @param id
     */
    void deleteRolePermission(@Param("id") Integer id);

    /**
     * 根据id获得一个role
     * @param id
     * @return
     */
    Role getOne(@Param("id")Integer id);

    /**
     * 删除role
     * @param id
     */
    void deleteRole(@Param("id")Integer id);

    /**
     * 根据role的id获得这个id下的所有permissions
     * @param id
     * @return
     */
    List<Permission> getPermissionByRoleId(@Param("id") Integer id);
}
