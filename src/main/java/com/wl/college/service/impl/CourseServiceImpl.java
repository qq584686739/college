package com.wl.college.service.impl;

import com.wl.college.dao.CourseDao;
import com.wl.college.dao.UserDao;
import com.wl.college.entity.Course;
import com.wl.college.entity.User;
import com.wl.college.exception.BizException;
import com.wl.college.exception.BizExceptionEnum;
import com.wl.college.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程
 * Created by DIY on 2017/8/18.
 */
@Service
public class CourseServiceImpl implements CourseService {
    private final UserDao userDao;
    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao, UserDao userDao) {
        this.courseDao = courseDao;
        this.userDao = userDao;
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
            course.setPids(pids+"["+ pid+ "],");
        }
        Integer insert = courseDao.insert(course);
        if(insert!=1){
            throw  new BizException(BizExceptionEnum.DB_INSERT_RESULT_ERROR);
        }

        return courseDao.findById(course.getId());
    }

    @Override
    public Course update(Course course) {
        Integer pid = course.getPid();
        System.out.println(course);
        if (pid != null) {
            Course pCourse = courseDao.findById(pid);
            String pids = pCourse.getPids() ;
            if(pids==null) {
                pids="";
            }
            course.setPids(pids+"["+ pid+ "],");
        }
        Integer update = courseDao.update(course);
        if(update!=1){
            throw new BizException(BizExceptionEnum.DB_UPDATE_RESULT_ERROR);
        }
        return courseDao.findById(course.getId());
    }

    @Override
    public List<Course> list(Course course, Double openPrice, Double endPrice, Integer offset, Integer limit, String sort, String order) {
        return courseDao.list(course,openPrice,endPrice,offset,limit,sort,order);
    }

    @Override
    public List<Course> userList(Course course, Double openPrice, Double endPrice, Integer offset, Integer limit, String sort, String order, Integer id) {
        User user = userDao.findById(id);
        course.setDeptId(user.getDeptId());
        return courseDao.list(course,openPrice,endPrice,offset,limit,sort,order);
    }

    @Override
    public Integer total(Course course, Double openPrice, Double endPrice) {
        return courseDao.total(course,openPrice,endPrice);
    }

    @Override
    public Integer userTotal(Course course, Double openPrice, Double endPrice, Integer id) {
        User user = userDao.findById(id);
        course.setDeptId(user.getDeptId());
        return courseDao.total(course,openPrice,endPrice);
    }

    @Override
    public void delete(Integer course) {
        Integer delete = courseDao.delete(course);
        if(delete!=1){
            throw new BizException(BizExceptionEnum.DB_DELETE_RESULT_ERROR);
        }
    }
}
