package com.wl.college.service;

import com.wl.college.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by DIY on 2017/8/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring-*.xml"})
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void listAllTest(){
        List<Role> list = roleService.listAll();
    }

    @Test
    public void createRoleTest(){
        Role role = new Role();
        role.setRole("role标志！！");
        role.setDescription("描述");
        role.setAvailable("启用还是不启用");
        List<Integer> permission = new ArrayList<>();

        permission.add(1);
        permission.add(2);

        roleService.createRole(role, permission);
    }
}
