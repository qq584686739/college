package com.wl.college.service.impl;

import com.wl.college.dao.OrderDao;
import com.wl.college.dao.UserCourseDao;
import com.wl.college.entity.Order;
import com.wl.college.entity.UserCourse;
import com.wl.college.exception.BizException;
import com.wl.college.exception.BizExceptionEnum;
import com.wl.college.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by DIY on 2017/8/21.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final UserCourseDao userCourseDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, UserCourseDao userCourseDao) {
        this.orderDao = orderDao;
        this.userCourseDao = userCourseDao;
    }

    @Override
    public Order create(Order order) {
        System.out.println(order);
        Integer insert = orderDao.create(order);
        if (insert != 1) {
            throw new BizException(BizExceptionEnum.DB_INSERT_RESULT_ERROR);
        }
        return orderDao.findById(order.getId());
    }

    @Transactional
    @Override
    public Order update(Order order) {
        Order old = orderDao.findById(order.getId());
        //未支付状态
        if(!old.getState().equals("1")) {
            //支付成功
            if (order.getState() != null && "0".equals(order.getState())) {
                //添加课程
                UserCourse userCourse = new UserCourse();
                userCourse.setCourseId(old.getCourseId());
                userCourse.setUserId(old.getUserId());
                Integer insert = userCourseDao.add(userCourse);
                if (insert != 1) {
                    throw new BizException(BizExceptionEnum.DB_INSERT_RESULT_ERROR);
                }
            }
        }else if(old.getState().equals("2")){ //取消订单
            return old;
        }
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
    public List<Map> list(Order order, Integer deptId, Integer offset, Integer limit, String sort, String rule) {
        return orderDao.list(order,deptId,offset,limit,sort,rule);
    }

    @Override
    public Integer total(Order order, Integer deptId) {
        return orderDao.total(order,deptId);
    }
}
