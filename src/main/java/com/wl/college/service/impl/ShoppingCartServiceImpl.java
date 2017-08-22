package com.wl.college.service.impl;

import com.wl.college.dao.OrderDao;
import com.wl.college.dao.ShoppingCartDao;
import com.wl.college.entity.Order;
import com.wl.college.entity.ShoppingCart;
import com.wl.college.exception.BizException;
import com.wl.college.exception.BizExceptionEnum;
import com.wl.college.service.OrderService;
import com.wl.college.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DIY on 2017/8/21.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartDao shoppingCartDao;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    /**
     * 查询购物车
     * @param id
     * @param offset
     * @param limit
     * @param sort  排序的字段
     * @param order 升序或降序
     * @return List<ShoppingCart>
     */
    @Override
    public List<ShoppingCart> list(Integer id, Integer offset, Integer limit, String sort, String order) {
        return shoppingCartDao.list(id, offset, limit, sort, order);
    }

    /**
     * 获得principal的购物车总数
     * @param principal
     * @return
     */
    @Override
    public Integer getTotal(Integer principal) {
        return shoppingCartDao.getTotal(principal);
    }

    /**
     * 增加购物车
     * @param shoppingCart
     */
    @Override
    public void add(ShoppingCart shoppingCart) {
        shoppingCartDao.add(shoppingCart);
    }
}
