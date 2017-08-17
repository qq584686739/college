package com.wl.college.service;

import com.wl.college.entity.User;

public interface UserService {

    /**
     * 根据唯一标记获取客户
     * @param id
     * @param email
     * @param phone
     * @param idCard
     * @return User
     */
    User getUserByTag(Integer id, String email, String phone, String idCard);

}
