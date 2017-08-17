package com.wl.college.service;

import com.wl.college.entity.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by DIY on 2017/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring-*.xml"})
public class PermissionServiceTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void findAllPermissionTest(){
        List list = permissionService.findAll();
    }

    @Test
    public void createPermissionTest(){
        Permission permission = new Permission();
        permission.setPermission("权限标志");
        permission.setDescription("这是描述");
        permission.setPid(1);
        permission.setPids("父级权限id链");
        permissionService.createPermission(permission);
    }
}
