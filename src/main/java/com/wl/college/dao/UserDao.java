package com.wl.college.dao;

import com.wl.college.entity.Role;
import com.wl.college.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;


public interface UserDao {

    /**
     * 创建一个用户
     *
     * @param user
     * @return
     */
    void createUser(@Param("user") User user);

    void updateDept(@Param("userId") int userId, @Param("deptId") Integer deptId);

    /**
     * 根据唯一标记获取客户
     *
     * @param id
     * @param mail
     * @param phone
     * @param idCard
     * @return
     */
    User getUserByTag(@Param("id") Integer id,
                      @Param("mail") String mail,
                      @Param("phone") String phone,
                      @Param("idCard") String idCard);

    /**
     * 根据唯一标记获得用户的角色
     *
     * @param id
     * @param mail
     * @param phone
     * @param idCard
     * @return
     */
    List<Role> hasRoles(@Param("id") Integer id, @Param("mail") String mail, @Param("phone") String phone, @Param("idCard") String idCard);

    Integer update(@Param("user") User manager, @Param("userId") Integer managerId);

    User findById(@Param("managerId") Integer managerId);

    void updateStateByDept(@Param("id") Integer id, @Param("state") String state);

    /**
     * 根据条件获取一部分user
     *
     * @param user
     * @param offset
     * @param limit
     * @param sort_field
     * @param sort_rule
     * @return
     */
    List<User> listUser(
            @Param("user") User user,
            @Param("offset") Integer offset,
            @Param("limit") Integer limit,
            @Param("sort_field") String sort_field,
            @Param("sort_rule") String sort_rule);

    /**
     * 根据筛选条件查找筛选条件下的所有user
     *
     * @param user
     * @return Integer
     */
    Integer findCount(@Param("user") User user);


    /**
     * 客户注册
     *
     * @param user
     * @return
     */
    Integer register(@Param("user") User user);

    /**
     * 修改密码
     */
    void changePwd(@Param("user") User user);

    /**
     * 根据唯一标识得到user的密码
     *
     * @param id
     * @param mail
     * @param phone
     * @param idCard
     * @return
     */
    User getUserPwdByTag(@Param("id") Integer id,
                         @Param("mail") String mail,
                         @Param("phone") String phone,
                         @Param("idCard") String idCard);

    /**
     * 根据id删除user_role
     * @param id
     */
    void deleteUserRole(@Param("id")Integer id);

    /**
     * 创建user_role
     * @param id
     * @param roleList
     */
    void createUserRole(@Param("id")Integer id, @Param("roleList")List<Integer> roleList);
}
