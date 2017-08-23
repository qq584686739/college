package com.wl.college.service;

import com.wl.college.entity.UserCollection;

import java.util.List;

/**
 * UserCollectionService
 * Created by XJH on 2017/8/23.
 */
public interface UserCollectionService {

    /**
     * 用户获得自己的收藏列表
     * @param id
     * @param userCollection
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return List<UserCollection>
     */
    List<UserCollection> list(
            Integer id, UserCollection userCollection, Integer offset, Integer limit, String sort, String order);

    /**
     * 添加收藏
     * @param userCollection
     */
    void add(UserCollection userCollection);

    /**
     * 取消收藏
     * @param principal
     * @param id
     */
    void delete(Integer principal, Integer id);
}
