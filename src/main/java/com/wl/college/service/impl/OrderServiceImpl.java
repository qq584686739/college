package com.wl.college.service.impl;

import com.wl.college.dao.OrderDao;
import com.wl.college.entity.Order;
import com.wl.college.exception.BizException;
import com.wl.college.exception.BizExceptionEnum;
import com.wl.college.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DIY on 2017/8/21.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order create(Order order) {
        System.out.println(order);
        Integer insert = orderDao.create(order);
        if (insert != 1) {
            throw new BizException(BizExceptionEnum.DB_INSERT_RESULT_ERROR);
        }
        return orderDao.findById(order.getId());
    }

    @Override
    public Order update(Order order) {
        Integer update = orderDao.update(order);
        if (update != 1) {
            throw new BizException(BizExceptionEnum.DB_UPDATE_RESULT_ERROR);
        }
        return orderDao.findById(order.getId());
    }

    @Override
    public void delete(Integer id) {
        Integer delete = orderDao.delete(id);
        if (delete != 1) {
            throw new BizException(BizExceptionEnum.DB_DELETE_RESULT_ERROR);
        }
    }

    @Override
    public List<Order> list(Order order, Integer deptId, Integer offset, Integer limit, String sort, String rule) {
        return orderDao.list(order,deptId,offset,limit,sort,rule);
    }

    @Override
    public Integer total(Order order, Integer deptId) {
        return orderDao.total(order,deptId);
    }
}
