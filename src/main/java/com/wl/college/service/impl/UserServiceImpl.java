package com.wl.college.service.impl;

import com.wl.college.dao.UserDao;
import com.wl.college.entity.Role;
import com.wl.college.entity.User;
import com.wl.college.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByTag(Integer id, String email, String phone, String idCard) {
        return userDao.getUserByTag(id, email, phone, idCard);
    }

    @Override
    public List<Role> hasRoles(Integer id, String email, String phone, String idCard) {
        return userDao.hasRoles(id, email, phone, idCard);
    }

    @Override
    public List<User> listUser(User user, Integer offset, Integer limit, String sort_field, String sort_rule){
        return userDao.listUser(user, offset, limit, sort_field, sort_rule);
    }

    @Override
    public Integer findCount(User user) {
        return userDao.findCount(user);
    }
}
