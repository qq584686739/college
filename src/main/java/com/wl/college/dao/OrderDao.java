package com.wl.college.dao;

import com.wl.college.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 * Created by DIY on 2017/8/21.
 */
public interface OrderDao {
    /**
     * 创建
     * @param order
     * @return
     */
    Integer create(@Param("order") Order order);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Order findById(@Param("id") Integer id);

    /**
     * 更新
     * @param order
     * @return
     */
    Integer update(@Param("order") Order order);

    /**
     * 删除
     * @param id
     * @return
     */
    Integer delete(@Param("id") Integer id);
}
