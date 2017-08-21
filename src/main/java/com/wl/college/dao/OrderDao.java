package com.wl.college.dao;

import com.wl.college.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * Created by DIY on 2017/8/21.
 */
public interface OrderDao {
    Integer create(@Param("order") Order order);
}
