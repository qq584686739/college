package com.wl.college.dao;

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

    /**
     * 更新一个用户
     *
     * @param user
     * @return
     */
    void updateUser(@Param("user") User user);

    /**
     * 根据id删除一个用户
     *
     * @param id
     */
    void deleteUser(@Param("id") Integer id);

    /**
     * 查询部分user列表
     *
     * @param user
     * @param offset
     * @param limit
     * @return
     */
    List<User> findSome(@Param("user") User user, @Param("role") String role, @Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 根据用户名找到permission的alias
     *
     * @param id
     * @return
     */
    Set<String> findPermissionsAliasById(@Param("id") Integer id);

    /**
     * 根据ID找到user
     *
     * @param id
     * @return
     */
    User findById(@Param("id") Integer id);

    /**
     * 根据ID找到permission.name的集合
     *
     * @param id
     * @return
     */
    Set<String> findPermissionsNameById(@Param("id") Integer id);

    /**
     * 根据userId找到role.name的集合
     *
     * @param userId
     * @return
     */
    Set<String> findRoleNamesByUserId(@Param("userId") Integer userId);

    /**
     * 创建user_role，批操作
     *
     * @param userId
     * @param roleList
     */
    void createUserRole(@Param("userId") Integer userId, @Param("roleList") List<Integer> roleList);

    /**
     * 删除user_role
     *
     * @param userId
     */
    void deleteUserRole(@Param("userId") Integer userId);

    /**
     * 冻结该账户
     *
     * @param state
     */
    void banState(@Param("id") Integer id, @Param("state") String state);

    /**
     * 根据userId找到role的
     *
     * @param userId
     * @return
     */
    List<Integer> findRoleIdsByUserId(@Param("userId") Integer userId);

    /**
     * 修改管理员的state
     *
     * @param state
     */
    void updateState(@Param("userId") Integer userId, @Param("state") String state);
}
