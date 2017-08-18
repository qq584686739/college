package com.wl.college.service.impl;

import com.wl.college.dao.CourseDao;
import com.wl.college.entity.Course;
import com.wl.college.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**课程
 * Created by DIY on 2017/8/18.
 */
@Service
public class CourseServiceImpl implements CourseService {
    final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public Course create(Course course) {
        return null;
    }
}
