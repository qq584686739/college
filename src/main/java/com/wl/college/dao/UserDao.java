package com.wl.college.dao;

import com.wl.college.entity.Role;
import com.wl.college.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据唯一标记获得用户的角色
     * @param id
     * @param email
     * @param phone
     * @param idCard
     * @return
     */
    List<Role> hasRoles(@Param("id")Integer id, @Param("email")String email, @Param("phone")String phone, @Param("idCard")String idCard);
}
