package com.wl.college.service.impl;

import com.wl.college.dao.CourseDao;
import com.wl.college.entity.Course;
import com.wl.college.exception.BizException;
import com.wl.college.exception.BizExceptionEnum;
import com.wl.college.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 课程
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
        Integer pid = course.getPid();
        System.out.println(course);
        if (pid != null) {
            Course pCourse = courseDao.findById(pid);
            String pids = pCourse.getPids() ;
            if(pids==null) {
                pids="";
            }
            course.setPids(pids+ pid+ ",");
        }
        Integer insert = courseDao.insert(course);
        if(insert!=1){
            throw  new BizException(BizExceptionEnum.DB_UPDATE_RESULT_ERROR);
        }

        return courseDao.findById(course.getId());
    }
}
