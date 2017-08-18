package com.wl.college.service;

import com.wl.college.entity.Role;
import com.wl.college.entity.User;

import java.util.List;

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

    /**
     * 根据唯一标记获得用户的角色
     * @param id
     * @param email
     * @param phone
     * @param idCard
     * @return List<Role>
     */
    List<Role> hasRoles(Integer id, String email, String phone, String idCard);

    /**
     * 根据条件获取一部分user
     * @param user
     * @param offset
     * @param limit
     * @param gender
     * @param dept_id
     * @return List<User>
     */
    List<User> listUser(User user, Integer offset, Integer limit, String gender, String dept_id);
}
