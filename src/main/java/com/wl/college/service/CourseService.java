package com.wl.college.service;

import com.wl.college.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * Created by DIY on 2017/8/18.
 */
public interface CourseService {
    Course create(Course course);

    Course update(Course course);
}
