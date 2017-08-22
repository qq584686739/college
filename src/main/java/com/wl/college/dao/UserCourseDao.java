package com.wl.college.dao;

import com.wl.college.entity.UserCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DIY on 2017/8/22.
 */
public interface UserCourseDao {
    Integer add(@Param("userCourse") UserCourse userCourse);

    Integer total(@Param("userCourse") UserCourse userCourse);

    List<UserCourse> list(@Param("userCourse") UserCourse userCourse);
}
