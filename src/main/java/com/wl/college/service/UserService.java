package com.wl.college.service;

import com.wl.college.entity.Role;
import com.wl.college.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 根据唯一标记获取客户
     *
     * @param id
     * @param mail
     * @param phone
     * @param idCard
     * @return User
     */
    User getUserByTag(Integer id, String mail, String phone, String idCard);

    /**
     * 根据唯一标记获得用户的角色
     *
     * @param id
     * @param mail
     * @param phone
     * @param idCard
     * @return List<Role>
     */
    List<Role> hasRoles(Integer id, String mail, String phone, String idCard);


    /**
     * 根据条件获取一部分user
     *
     * @param user   筛选条件user
     * @param offset 起始数
     * @param limit  需要数
     * @param sort   排序的字段
     * @param order  排序的规则
     * @return
     */
    List<User> listUser(User user, Integer offset, Integer limit, String sort, String order);

    /**
     * 根据筛选调教查找条件下的所有user
     *
     * @param user
     * @return
     */
    Integer findCount(User user);

    /**
     * 更新user信息
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 客户注册
     *
     * @param user
     * @return
     */
    Integer register(User user);

    /**
     * 修改密码
     *
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Integer changePwd(Integer id, String oldPassword, String newPassword);

    /**
     * 根据唯一标识得到user的密码
     *
     * @param id
     * @param mail
     * @param phone
     * @param idCard
     * @return
     */
    User getUserPwdByTag(Integer id, String mail, String phone, String idCard);

    /**
     * 更新user_role
     *
     * @param id
     * @param roleList
     */
    void updateUserRole(Integer id, List<Integer> roleList);

    /**
     * 用户签到
     * @param   principal
     * @return  Integer     返回已经签到的天数(已算上本次)
     */
    Integer sign(Integer principal);
}
