package com.wl.college.dao;


import com.wl.college.entity.Permission;

import java.util.List;


public interface PermissionDao {

    /**
     * 找到系统所有权限
     *
     * @return
     */
    List<Permission> findAll();

}
