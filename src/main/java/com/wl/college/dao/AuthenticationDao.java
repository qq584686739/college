package com.wl.college.dao;

import com.wl.college.entity.Authentication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DIY on 2017/8/22.
 */
public interface AuthenticationDao {
    Integer create(@Param("authentication") Authentication authentication);

    Authentication findById(@Param("id") Integer id);

    Integer update(@Param("authentication") Authentication authentication);

    Integer total(@Param("authentication") Authentication authentication);

    List<Authentication> list(@Param("authentication") Authentication authentication, @Param("offset") Integer offset,
                              @Param("limit") Integer limit, @Param("sort") String sort, @Param("order") String order);
}
