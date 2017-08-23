package com.wl.college.service.impl;

import com.wl.college.dao.UserCollectionDao;
import com.wl.college.entity.UserCollection;
import com.wl.college.service.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserCollectionService
 * Created by XJH on 2017/8/23.
 */
@Service
public class UserCollectionServiceImpl implements UserCollectionService {

    @Autowired
    private UserCollectionDao userCollectionDao;

    /**
     * 用户获得自己的收藏列表
     *
     * @param id
     * @param userCollection
     * @param offset
     * @param limit
     * @param sort
     * @param order
     * @return List<UserCollection>
     */
    @Override
    public List<UserCollection> list(
            Integer id, UserCollection userCollection, Integer offset, Integer limit, String sort, String order) {
        return userCollectionDao.list(id, userCollection, offset, limit, sort, order);
    }

    /**
     * 添加收藏
     *
     * @param userCollection
     */
    @Override
    public void add(UserCollection userCollection) {
        userCollectionDao.add(userCollection);
    }

    /**
     * 取消收藏
     *
     * @param principal
     * @param id
     */
    @Override
    public void delete(Integer principal, Integer id) {
        userCollectionDao.delete(principal, id);
    }
}
