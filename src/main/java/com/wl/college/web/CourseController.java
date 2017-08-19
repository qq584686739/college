package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.Course;
import com.wl.college.entity.Dept;
import com.wl.college.service.CourseService;
import org.apache.shiro.SecurityUtils;
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

    /**
     * 管理员查课程
     * @param course
     * @param openPrice
     * @param endPrice
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @GetMapping(produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Course> adminList(Course course,
                                             @RequestParam(value = "open_price", required = false)Double openPrice,
                                             @RequestParam(value = "end_price", required = false)Double endPrice,
                                             @RequestParam(value = "offset",required = false, defaultValue = "0")Integer offset,
                                             @RequestParam(value = "limit", required = false, defaultValue = "100")Integer limit,
                                             @RequestParam(value = "sort", required = false, defaultValue = "id")String sort,
                                             @RequestParam(value = "order", required = false, defaultValue = "ASC")String order) {
        System.out.println(course);
        return new BootStrapTableResult<>(courseService.total(course,openPrice,endPrice), courseService.list(course,openPrice,endPrice,offset,limit,sort,order));
    }

    /**
     * 用户查课程
     * @param course
     * @param openPrice
     * @param endPrice
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @GetMapping(value = "user",produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Course> userList(@RequestParam(value = "course", required = false)Course course,
                                                  @RequestParam(value = "open_price", required = false)Double openPrice,
                                                  @RequestParam(value = "end_price", required = false)Double endPrice,
                                                  @RequestParam(value = "offset",required = false, defaultValue = "0")Integer offset,
                                                  @RequestParam(value = "limit", required = false, defaultValue = "100")Integer limit,
                                                  @RequestParam(value = "sort", required = false, defaultValue = "id")String sort,
                                                  @RequestParam(value = "order", required = false, defaultValue = "ASC")String order) {
        Integer id = (Integer) SecurityUtils.getSubject().getPrincipal();
        return new BootStrapTableResult<>(courseService.userTotal(course,openPrice,endPrice,id), courseService.userList(course,openPrice,endPrice,offset,limit,sort,order,id));
    }

    /**
     * 平台查课程
     * @param course
     * @param openPrice
     * @param endPrice
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    @GetMapping(value = "dept",produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Course> deptList(@RequestParam(value = "course", required = false)Course course,
                                                 @RequestParam(value = "open_price", required = false)Double openPrice,
                                                 @RequestParam(value = "end_price", required = false)Double endPrice,
                                                 @RequestParam(value = "offset",required = false, defaultValue = "0")Integer offset,
                                                 @RequestParam(value = "limit", required = false, defaultValue = "100")Integer limit,
                                                 @RequestParam(value = "sort", required = false, defaultValue = "id")String sort,
                                                 @RequestParam(value = "order", required = false, defaultValue = "ASC")String order) {
        Integer id = (Integer) SecurityUtils.getSubject().getPrincipal();
        course.setDeptId(id);
        return new BootStrapTableResult<>(courseService.total(course,openPrice,endPrice), courseService.list(course,openPrice,endPrice,offset,limit,sort,order));
    }

}
