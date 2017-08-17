package com.wl.college.dao;

import com.wl.college.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;


public interface UserDao {

    /**
     * 根据唯一标记获取客户
     * @param id
     * @param email
     * @param phone
     * @param idCard
     * @return
     */
    User getUserByTag(@Param("id")Integer id, @Param("email")String email, @Param("phone")String phone, @Param("idCard")String idCard) ;
}
