package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.entity.Course;
import com.wl.college.entity.Order;
import com.wl.college.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DIY on 2017/8/21.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 添加订单
     *
     * @param order 订单信息
     * @return
     */
    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Order> create(Order order) {
        return new BaseResult<>(true, orderService.create(order));
    }



}
