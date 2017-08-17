package com.wl.college.service;



import com.wl.college.entity.User;

import java.util.List;
import java.util.Set;


public interface UserService {

    /**
     * 根据唯一标记获取客户
     *
     * @param id
     * @param email
     * @param idCard
     * @return
     */
    User getUserByTag(Integer id, String email, String idCard);

//    /**
//     * 查询user列表
//     *
//     * @param user
//     * @param offset
//     * @param limit
//     * @return
//     */
//    List<User> findSome(User user, String role, Integer offset, Integer limit);
//
//    /**
//     * 创建用户
//     *
//     * @param user
//     */
//    void createUser(User user);
//
//    /**
//     * 更新用户
//     *
//     * @param user
//     * @return
//     */
//    public void updateUser(User user);
//
//    /**
//     * 删除一个用户
//     *
//     * @param userId
//     */
//    public void deleteUser(Integer userId);
//
//    /**
//     * 修改密码
//     *
//     * @param userId
//     * @param oldPassword
//     * @param newPassword
//     */
//    public void changePassword(Integer userId, String oldPassword, String newPassword);
//
//    /**
//     * 根据用户名查找其角色
//     *
//     * @param id
//     * @return
//     */
//    public Set<String> findRoleNamesByUserId(Integer id);
//
//
//
//    /**
//     * 根据Id找User
//     *
//     * @param id
//     * @return
//     */
//    User findById(Integer id);
//
//    /**
//     * 根据userId找到permission的alias
//     *
//     * @param id
//     * @return
//     */
//    Set<String> findPermissionsAliasById(Integer id);
//
//    /**
//     * 根据userId找到permission.name的集合
//     *
//     * @param id
//     * @return
//     */
//    Set<String> findPermissionsNameById(Integer id);
//
//    /**
//     * 更新user_role
//     *
//     * @param userId
//     * @param roleList
//     */
//    void updateUserRole(Integer userId, List<Integer> roleList);
//
//    /**
//     * 冻结/解冻   user账户
//     * @param id
//     * @param state
//     */
//    void banState(Integer id, String state);
//
//    /**
//     * 根据userId获得roleIds
//     *
//     * @param userId
//     * @return
//     */
//    List<Integer> findRoleIdsByUserId(Integer userId);
//
//    /**
//     * 修改管理官的state
//     *
//     * @param userId
//     * @param state
//     */
//    void updateState(Integer userId, String state);
//
//
//    /**
//     * 创建user_role
//     * @param userId
//     * @param roleList
//     */
//    public void createUserRole(Integer userId, List<Integer> roleList) ;
}
