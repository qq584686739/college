package com.wl.college.dao;

import com.wl.college.entity.Role;
import com.wl.college.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;


public interface UserDao {

    /**
     * 创建一个用户
     * @param user
     * @return
     */
    void createUser(@Param("user") User user);

    void updateDept(@Param("userId") int userId, @Param("deptId") Integer deptId);

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

    Integer update(@Param("user") User manager, @Param("userId") Integer managerId);

    User findById(@Param("managerId") Integer managerId);
}
