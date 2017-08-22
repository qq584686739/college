package com.wl.college.service.impl;

import com.wl.college.dao.UserCourseDao;
import com.wl.college.entity.UserCourse;
import com.wl.college.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DIY on 2017/8/22.
 */
@Service
public class UserCourseServiceImpl implements UserCourseService {

    private final UserCourseDao userCourseDao;

    @Autowired
    public UserCourseServiceImpl(UserCourseDao userCourseDao) {
        this.userCourseDao = userCourseDao;
    }

    @Override
    public Integer total(UserCourse userCourse) {
        return userCourseDao.total(userCourse);
    }

    @Override
    public List<UserCourse> list(UserCourse userCourse, Integer offset, Integer limit, String sort, String order, Integer id) {
        return userCourseDao.list(userCourse);
    }
}
