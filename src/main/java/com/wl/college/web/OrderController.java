package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.Comment;
import com.wl.college.entity.Course;
import com.wl.college.entity.Order;
import com.wl.college.entity.User;
import com.wl.college.service.OrderService;
import com.wl.college.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by DIY on 2017/8/21.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
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

    /**
     * 修改订单
     * @param order
     * @return
     */
    @PutMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Order> update(Order order) {
        return new BaseResult<>(true, orderService.update(order));
    }

    /**
     * 删订单
     *
     * @return
     */
    @DeleteMapping(value = "/{id}",produces = {"application/json;charset=UTF-8"})
    public BaseResult delete(@PathVariable Integer id) {
        orderService.delete(id);
        return new BaseResult(true,null);
    }

    /**
     * 用户查订单
     * @param order
     * @return
     */
    @GetMapping(value = "/user",produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Order> userList(Order order) {
        order.setUserId((Integer) SecurityUtils.getSubject().getPrincipal());
        return new BootStrapTableResult<>(orderService.total(order), orderService.list(order));
    }





}
