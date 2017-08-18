package com.wl.college.service.impl;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.wl.college.dao.DeptDao;
import com.wl.college.dao.UserDao;
import com.wl.college.entity.Dept;
import com.wl.college.entity.User;
import com.wl.college.enums.ResultEnum;
import com.wl.college.service.DeptService;
import com.wl.college.utils.IdCardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.wl.college.enums.Constants.USER_FILE_SAVE_RELATIVE_PATH;

/**
 * Created by DIY on 2017/8/17.
 */
@Service
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
    public Dept register(Dept dept) {
        User manager = dept.getManager();
        manager.setState("1");
        //创建用户(负责人)
        userDao.createUser(manager);
        List<Integer> roleList=new ArrayList<Integer>();
        //加角色
        roleList.add(1);
        //添加用户权限
//        userDao.createUserRole(user.getId(),roleList);
        dept.setManagerId(dept.getManager().getId());
        dept.setState("1");
        System.out.println(dept);
        //创建平台
        deptDao.create(dept);
        //给平台的超级管理员分配组织
        userDao.updateDept(dept.getManager().getId(),dept.getId());
        return deptDao.findById(dept.getId());
    }

    @Transactional
    @Override
    public Dept update(Dept dept) {
        //更新dept
        Integer deptUpdate = deptDao.update(dept);
        if(deptUpdate!=1){
            throw  new RuntimeException(ResultEnum.DB_UPDATE_RESULT_ERROR.getMsg());
        }
        //根据dept 查找managerid
        Dept result = deptDao.findById(dept.getId());
        User manager = dept.getManager();
        //设置密码和生日性别
        String pseeword = (int) ((Math.random() * 9 + 1) * 100000) + "";
        manager.setPassword(pseeword);
        IdCardUtil.getBirthdateAndGender(manager);
        //更新
        Integer userUpdate = userDao.update(manager, result.getManagerId());
        if(userUpdate!=1){
            throw  new RuntimeException(ResultEnum.DB_UPDATE_RESULT_ERROR.getMsg());
        }
        System.out.println(result.getManagerId());
        User user=userDao.findById(result.getManagerId());
        user.setPassword(pseeword);
        result.setManager(user);
        return result;
    }

    @Override
    public void changeState(Integer id, String state) {
        deptDao.updateState(id,state);
        userDao.updateStateByDept(id,state);
    }
}
