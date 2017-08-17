package com.wl.college.dao;


import com.wl.college.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface PermissionDao {

    /**
     * 找到系统所有权限
     *
     * @return
     */
    List<Permission> findAll();


    /**
     * 创建一个权限
     * @param permission
     */
    void createPermission(@Param("permission") Permission permission);
}
