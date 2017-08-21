package com.wl.college.service;

import com.wl.college.entity.Order;

import java.util.List;

/**
 * Created by DIY on 2017/8/21.
 */
public interface OrderService {
    Order create(Order order);

    Order update(Order order);

    void delete(Integer id);

    List<Order> list(Order order, Integer deptId, Integer offset, Integer limit, String sort, String rule);

    Integer total(Order order, Integer deptId);
}
