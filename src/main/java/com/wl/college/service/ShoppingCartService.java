package com.wl.college.service;


import com.wl.college.entity.ShoppingCart;

import java.util.List;

/**
 * Created by DIY on 2017/8/21.
 */
public interface ShoppingCartService {

    /**
     * 查询购物车
     * @param offset
     * @param limit
     * @param sort  排序的字段
     * @param order 升序或降序
     * @return List<ShoppingCart>
     */
    List<ShoppingCart> list(Integer id, Integer offset, Integer limit, String sort, String order);

    /**
     * 获得principal的购物车总数
     * @param principal
     * @return
     */
    Integer getTotal(Integer principal);

    /**
     * 增加购物车
     * @param shoppingCart
     */
    void add(ShoppingCart shoppingCart);
}
