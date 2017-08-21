package com.wl.college.service.impl;

import com.wl.college.dao.OrderDao;
import com.wl.college.entity.Order;
import com.wl.college.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DIY on 2017/8/21.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order create(Order order) {
        orderDao.create(order);
        return null;
    }
}
