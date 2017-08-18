package com.wl.college.dao;

import com.wl.college.entity.Course;
import org.apache.ibatis.annotations.Param;

/**
 * Created by DIY on 2017/8/18.
 */
public interface CourseDao {
    Integer insert(@Param("course") Course course);

    Course findById(@Param("id") Integer id);
}
