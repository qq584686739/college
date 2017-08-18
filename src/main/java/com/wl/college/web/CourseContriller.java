package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.entity.Course;
import com.wl.college.entity.Dept;
import com.wl.college.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DIY on 2017/8/18.
 */
@RestController
@RequestMapping("/courses")
public class CourseContriller {
    final
    private CourseService courseService;

    @Autowired
    public CourseContriller(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Course> create(Course course) {
        return new BaseResult<>(true, courseService.create(course));
    }

}
