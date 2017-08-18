package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.entity.Course;
import com.wl.college.entity.Dept;
import com.wl.college.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by DIY on 2017/8/18.
 */
@RestController
@RequestMapping("/courses")
public class CourseController {
    final private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * 添加课程
     *
     * @param course 课程信息
     * @return
     */
    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Course> create(Course course) {
        return new BaseResult<>(true, courseService.create(course));
    }

    /**
     * 修改课程
     * @param course
     * @return
     */
    @PutMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Course> update(Course course) {
        return new BaseResult<>(true, courseService.update(course));
    }

    @GetMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Course> list(Course course) {
        return new BaseResult<>(true, courseService.update(course));
    }

}
