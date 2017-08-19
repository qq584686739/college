package com.wl.college.dao;

import com.wl.college.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DIY on 2017/8/19.
 */
public interface ResourceDao {
    Integer create(@Param("resource") Resource resource);

    Resource findById(@Param("id") Integer id);

    Integer delete(@Param("resource") Integer resource);

    Integer update(@Param("resource")Resource resource);

    Integer total(@Param("resource") Resource resource);

    List<Resource> list(@Param("resource") Resource resource, @Param("offset") Integer offset, @Param("limit") Integer limit,
                        @Param("sort") String sort, @Param("order") String order);
}
