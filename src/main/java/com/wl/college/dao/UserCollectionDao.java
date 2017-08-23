package com.wl.college.dao;

import com.wl.college.entity.UserCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by XJH on 2017/8/23.
 */
public interface UserCollectionDao {
    /**
     * user查询自己的收藏列表
     * @param id
     * @param userCollection
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return
     */
    List<UserCollection> list(@Param("id") Integer id,
                              @Param("userCollection") UserCollection userCollection,
                              @Param("offset")Integer offset,
                              @Param("limit")Integer limit,
                              @Param("sort")String sort,
                              @Param("order")String order);

    /**
     * 添加收藏
     * @param userCollection
     */
    void add(@Param("userCollection")UserCollection userCollection);

    /**
     * 取消收藏
     * @param principal
     * @param id
     */
    void delete(@Param("principal") Integer principal, @Param("id") Integer id);
}
