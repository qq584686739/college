package com.wl.college.service;


import com.wl.college.entity.Permission;

import java.util.List;

public interface PermissionService {

    /**
     * 找到所有权限
     * @return List<Permission>
     */
    List<Permission> findAll();

    /**
     * 创建一个权限
     * @param permission
     */
    void createPermission(Permission permission);

}
