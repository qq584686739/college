package com.wl.college.web;

import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.UserCourse;
import com.wl.college.service.UserCourseService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserCourseController
 * Created by DIY on 2017/8/22.
 */
@RestController
@RequestMapping("/user/courses")
public class UserCourseController {

    private final UserCourseService userCourseService;

    @Autowired
    public UserCourseController(UserCourseService userCourseService) {
        this.userCourseService = userCourseService;
    }

    /**
     * 用户查拥有课程
     *
     * @param userCourse
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @GetMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<UserCourse> userList(UserCourse userCourse,
                                                     @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
                                                     @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
                                                     @RequestParam(value = "sort", required = false, defaultValue = "id") String sort,
                                                     @RequestParam(value = "order", required = false, defaultValue = "ASC") String order) {
        Integer id = (Integer) SecurityUtils.getSubject().getPrincipal();
        return new BootStrapTableResult<>(userCourseService.total(userCourse),
                userCourseService.list(userCourse, offset, limit, sort, order, id));
    }
}
