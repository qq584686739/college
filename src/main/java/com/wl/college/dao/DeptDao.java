package com.wl.college.dao;

import com.wl.college.entity.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * Created by DIY on 2017/8/17.
 */
public interface DeptDao {
    void create(@Param("dept") Dept dept);

    Dept findById(@Param("id") Integer id);
}
