package com.wl.college.service;

import com.wl.college.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * Created by DIY on 2017/8/21.
 */
public interface OrderService {
    Order create(Order order);

    Order update(Order order);

    void delete(Integer id);

    List<Map> list(Order order, Integer deptId, Integer offset, Integer limit, String sort, String rule);

    Integer total(Order order, Integer deptId);
}
