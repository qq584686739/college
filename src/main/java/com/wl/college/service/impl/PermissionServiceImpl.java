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

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void createPermission(Permission permission) {
        permissionDao.createPermission(permission);
    }
}
