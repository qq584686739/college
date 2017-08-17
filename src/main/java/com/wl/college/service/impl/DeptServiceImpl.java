package com.wl.college.service.impl;

import com.wl.college.dao.DeptDao;
import com.wl.college.dao.UserDao;
import com.wl.college.entity.Dept;
import com.wl.college.entity.User;
import com.wl.college.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.wl.college.enums.Constants.USER_FILE_SAVE_RELATIVE_PATH;

/**
 * Created by DIY on 2017/8/17.
 */
public class DeptServiceImpl implements DeptService{

    private final DeptDao deptDao;
    private final UserDao userDao;

    @Autowired
    public DeptServiceImpl(DeptDao deptDao, UserDao userDao) {
        this.deptDao = deptDao;
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public Dept register(Dept dept, User user) {
        //创建用户(负责人)
        userDao.createUser(user);
        List<Integer> roleList=new ArrayList<Integer>();
        //加权限
        roleList.add(1);
        //添加用户权限
        userDao.createUserRole(user.getId(),roleList);
        dept.setManagerId(user.getId());
        //创建平台
        deptDao.create(dept);
        //给平台的超级管理员分配组织
        userDao.updateDept(user.getId(),dept.getId());
        return deptDao.findById(dept.getId());

    }
}