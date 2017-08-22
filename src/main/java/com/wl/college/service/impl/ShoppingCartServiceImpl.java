package com.wl.college.service.impl;

import com.alibaba.druid.support.http.ResourceServlet;
import com.wl.college.dao.CourseDao;
import com.wl.college.dao.OrderDao;
import com.wl.college.dao.ResourceDao;
import com.wl.college.dao.ShoppingCartDao;
import com.wl.college.entity.Course;
import com.wl.college.entity.Order;
import com.wl.college.entity.Resource;
import com.wl.college.entity.ShoppingCart;
import com.wl.college.exception.BizException;
import com.wl.college.exception.BizExceptionEnum;
import com.wl.college.service.CourseService;
import com.wl.college.service.OrderService;
import com.wl.college.service.ResourceService;
import com.wl.college.service.ShoppingCartService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by DIY on 2017/8/21.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartDao shoppingCartDao;
    private final OrderDao orderDao;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, OrderDao orderDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.orderDao = orderDao;
    }

    /**
     * 查询购物车
     *
     * @param id
     * @param offset
     * @param limit
     * @param sort   排序的字段
     * @param order  升序或降序
     * @return List<ShoppingCart>
     */
    @Override
    public List<ShoppingCart> list(Integer id, Integer offset, Integer limit, String sort, String order) {
        return shoppingCartDao.list(id, offset, limit, sort, order);
    }

    /**
     * 获得principal的购物车总数
     *
     * @param principal
     * @return
     */
    @Override
    public Integer getTotal(Integer principal) {
        return shoppingCartDao.getTotal(principal);
    }

    /**
     * 增加购物车
     *
     * @param shoppingCart
     */
    @Override
    public void add(ShoppingCart shoppingCart) {
        shoppingCartDao.add(shoppingCart);
    }

    /**
     * 删除购物车一条记录
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        shoppingCartDao.delete(id);
    }

    /**
     * 增加购物车之前检查是否存在
     *
     * @param shoppingCart
     * @return true：存在
     * false：不存在
     */
    @Override
    public Boolean isExist(ShoppingCart shoppingCart) {
        return shoppingCartDao.isExist(shoppingCart) != null;
    }

    /**
     * 根据id得到一条购物车信息
     *
     * @param id
     * @return
     */
    @Override
    public ShoppingCart findOne(Integer principal, Integer id) {
        return shoppingCartDao.findOne(principal, id);
    }

    /**
     * 购物车生成订单
     *
     * @param principal
     * @param id
     * @return
     */
    @Override
    public Order generateOrder(Integer principal, Integer id) {
        //1、根据id查询购物车
        ShoppingCart shoppingCart = shoppingCartDao.findOne(principal, id);

        if (shoppingCart == null) {
            throw new RuntimeException("购物车找不到该id");         // TODO: 2017/8/22 异常代号
        }

        Order order = new Order();
        order.setCredits(shoppingCart.getCourse().getCredits());              //设置积分
        order.setAmount(shoppingCart.getCourse().getPrice());                 //设置金钱
        order.setType(shoppingCart.getType());              //设置类型
        order.setCourseId(shoppingCart.getCourseId());  //设置resource_id
        order.setUserId(shoppingCart.getUserId());          //设置user_id

        //2、创建订单
        orderDao.create(order);

        //3、根据id删除购物车
        shoppingCartDao.delete(shoppingCart.getId());

        return order;
    }

    /**
     * 购物车批量生成订单
     *
     * @param principal
     * @param ids
     * @return
     */
    @Override
    // TODO: 2017/8/22 事务
    public List<Order> generateOrders(Integer principal, List<Integer> ids) {
        List<ShoppingCart> list = shoppingCartDao.findSome(principal, ids);
        if(list == null){
            throw new RuntimeException("购物车找不到数据");         // TODO: 2017/8/22 错误代码
        }

        Iterator<ShoppingCart> iterator = list.iterator();
        Order order;
        List<Order> result = new ArrayList<>();
        while (iterator.hasNext()) {
            order = new Order();

            ShoppingCart shoppingCart = iterator.next();
            
            order.setCredits(shoppingCart.getCourse().getCredits());              //设置积分
            order.setAmount(shoppingCart.getCourse().getPrice());                 //设置金钱
            order.setType(shoppingCart.getType());                                //设置类型
            order.setCourseId(shoppingCart.getCourseId());                        //设置resource_id
            order.setUserId(shoppingCart.getUserId());                            //设置user_id
            result.add(order);
        }

        //批量创建订单
        orderDao.createSome(principal, result);

        //批量删除购物车
        shoppingCartDao.deleteSome(principal, ids);


        return result;
    }

    /**
     * 批量删除购物车
     *
     * @param id
     * @param ids
     */
    @Override
    public void deleteSome(Integer id, List<Integer> ids) {
        shoppingCartDao.deleteSome(id, ids);
    }
}
