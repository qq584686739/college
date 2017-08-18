package com.wl.college.dao;

import com.wl.college.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DIY on 2017/8/17.
 */
public interface DeptDao {
    void create(@Param("dept") Dept dept);

    Dept findById(@Param("id") Integer id);

    Integer update(@Param("dept") Dept dept);

    Integer updateState(@Param("id") Integer id, @Param("state") String state);

    List<Dept> list(@Param("dept") Dept dept, @Param("offset") Integer offset, @Param("limit") Integer limit,
                    @Param("field") String field, @Param("rule") String rule);
}
