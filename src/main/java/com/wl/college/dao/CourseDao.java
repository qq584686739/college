package com.wl.college.dao;

import com.wl.college.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DIY on 2017/8/18.
 */
public interface CourseDao {
    /**
     * 创建
     * @param course
     * @return
     */
    Integer insert(@Param("course") Course course);

    /**
     * 根据id查
     * @param id
     * @return
     */
    Course findById(@Param("id") Integer id);

    /**
     * 更新
     * @param course
     * @return
     */
    Integer update(@Param("course") Course course);

    /**
     * 列表
     * @param course
     * @param openPrice
     *@param endPrice
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    List<Course> list(@Param("course") Course course, @Param("openPrice")Double openPrice, @Param("endPrice")Double endPrice,
                      @Param("offset") Integer offset, @Param("limit") Integer limit, @Param("sort") String sort, @Param("order") String order);

    /**
     * 总行数
     * @param course
     * @param openPrice
     * @param endPrice
     * @return
     */
    Integer total(@Param("course") Course course, @Param("openPrice") Double openPrice, @Param("endPrice") Double endPrice);

    Integer delete(@Param("course") Course course);
}
