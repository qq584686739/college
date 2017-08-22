package com.wl.college.dao;

import com.wl.college.entity.ShoppingCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DIY on 2017/8/21.
 */
public interface ShoppingCartDao {
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
    List<ShoppingCart> list(@Param("id") Integer id, @Param("offset") Integer offset, @Param("limit") Integer limit,
                            @Param("sort") String sort, @Param("order") String order);

    /**
     * 获得principal的购物车总数
     *
     * @param principal
     * @return
     */
    Integer getTotal(@Param("principal") Integer principal);

    /**
     * 增加购物车
     *
     * @param shoppingCart
     */
    void add(@Param("shoppingCart") ShoppingCart shoppingCart);

    /**
     * 增加购物车之前检查是否存在
     *
     * @param shoppingCart
     * @return
     */
    ShoppingCart isExist(@Param("shoppingCart") ShoppingCart shoppingCart);

    /**
     * 根据id得到一条购物车信息
     *
     * @param principal
     * @param id
     * @return
     */
    ShoppingCart findOne(@Param("principal") Integer principal, @Param("id") Integer id);

    /**
     * 删除购物车一条记录
     *
     * @param id
     */
    void delete(@Param("id") Integer id);

    /**
     * 批量删除购物车
     *
     * @param id
     * @param ids
     */
    void deleteSome(@Param("id") Integer id, @Param("ids") List<Integer> ids);

    /**
     * 批量查找
     * @param principal
     * @param ids
     * @return
     */
    List<ShoppingCart> findSome(@Param("principal")Integer principal, @Param("ids")List<Integer> ids);
}
