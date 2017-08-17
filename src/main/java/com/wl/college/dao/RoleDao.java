package com.wl.college.dao;


import com.wl.college.entity.Role;

import java.util.List;

public interface RoleDao {

    /**
     * 找到系统所有角色
     *
     * @return
     */
    List<Role> findAll();
}
