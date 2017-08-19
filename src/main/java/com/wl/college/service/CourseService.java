package com.wl.college.service;

import com.wl.college.entity.Course;

import java.util.List;

/**
 * Created by DIY on 2017/8/18.
 */
public interface CourseService {
    /**
     * 创建课程
     * @param course
     * @return
     */
    Course create(Course course);

    /**
     * 更新课程
     * @param course
     * @return
     */
    Course update(Course course);

    /**
     * 课程列表
     * @param course
     * @param openPrice
     *@param endPrice
     * @param offset
     * @param limit
     * @param sort
     * @param order     @return
     */
    List<Course> list(Course course, Double openPrice, Double endPrice, Integer offset, Integer limit, String sort, String order);

    /**
     * 课程列表（user）
     * @param course
     * @param openPrice
     * @param endPrice
     * @param offset
     * @param limit
     * @param sort
     * @param order     @return
     * @param id
     * */
    List<Course> userList(Course course, Double openPrice, Double endPrice, Integer offset, Integer limit, String sort, String order, Integer id);

    /**
     * 总行数
     * @param course
     * @param openPrice
     *@param endPrice @return
     */
    Integer total(Course course, Double openPrice, Double endPrice);

    /**
     * 总行数（user）
     * @param course
     * @param openPrice
     * @param endPrice
     * @param id
     * @return
     */
    Integer userTotal(Course course, Double openPrice, Double endPrice, Integer id);
}
