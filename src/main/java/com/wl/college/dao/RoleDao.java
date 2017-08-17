package com.wl.college.dao;


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
}
