package com.wl.college.service;

import com.wl.college.entity.UserCourse;

import java.util.List;

/**
 * Created by DIY on 2017/8/22.
 */
public interface UserCourseService {
    Integer total(UserCourse userCourse);

    List<UserCourse> list(UserCourse userCourse, Integer offset, Integer limit,
                          String sort, String order, Integer id);
}
