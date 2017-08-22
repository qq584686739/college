package com.wl.college.service.impl;

import com.wl.college.dao.PermissionDao;
import com.wl.college.entity.Permission;
import com.wl.college.service.PermissionService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionDao permissionDao;

    /**
     * 找到所有权限
     * @return
     */
    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    /**
     * 创建一个权限
     * @param permission
     */
    @Override
    public void createPermission(Permission permission) {
        permissionDao.createPermission(permission);
    }

    /**
     * 获取principal的权限
     * @param principal
     * @return
     */
    @Override
    public List<Permission> hasPermissions(Integer principal) {
        return permissionDao.hasPermissions(principal);
    }
}
