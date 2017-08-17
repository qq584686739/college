package com.wl.college.service.impl;

import com.wl.college.dao.UserDao;
import com.wl.college.entity.User;
import com.wl.college.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByTag(Integer id, String email, String phone, String idCard) {
        return userDao.getUserByTag(id, email, phone, idCard);
    }
}
