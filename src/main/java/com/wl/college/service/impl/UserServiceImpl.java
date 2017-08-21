package com.wl.college.service.impl;

import com.wl.college.dao.UserDao;
import com.wl.college.entity.Role;
import com.wl.college.entity.User;
import com.wl.college.service.UserService;
import com.wl.college.utils.PasswordHelperUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 根据唯一标记获取客户
     *
     * @param id
     * @param email
     * @param phone
     * @param idCard
     * @return User
     */
    @Override
    public User getUserByTag(Integer id, String email, String phone, String idCard) {
        return userDao.getUserByTag(id, email, phone, idCard);
    }

    /**
     * 根据唯一标记获得用户的角色
     *
     * @param id
     * @param email
     * @param phone
     * @param idCard
     * @return List<Role>
     */
    @Override
    public List<Role> hasRoles(Integer id, String email, String phone, String idCard) {
        return userDao.hasRoles(id, email, phone, idCard);
    }

    /**
     * 根据条件获取一部分user
     *
     * @param user
     * @param offset
     * @param limit
     * @param sort_field
     * @param sort_rule
     * @return List<User>
     */
    @Override
    public List<User> listUser(User user, Integer offset, Integer limit, String sort_field, String sort_rule) {
        return userDao.listUser(user, offset, limit, sort_field, sort_rule);
    }

    /**
     * 根据筛选调教查找条件下的所有user
     *
     * @param user
     * @return Integer
     */
    @Override
    public Integer findCount(User user) {
        return userDao.findCount(user);
    }

    /**
     * 更新user
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        userDao.update(user, user.getId());
    }

    /**
     * 客户注册
     * @param user
     */
    @Override
    public void register(User user) {
        //设置密码和salt
        String salt = PasswordHelperUtil.getSalt();
        user.setSalt(salt);
        user.setPassword(PasswordHelperUtil.getEncryptPassword(salt, user.getPassword()));
        userDao.register(user);
    }

    /**
     * 修改密码
     * return 0: 修改成功
     * return 1:
     * return 2:
     * @param oldPassword
     * @param newPassword
     * @return
     *          1：不符合正则规定
     *          2：oldPassword错误
     *
     */
    @Override
    public Integer changePwd(String oldPassword, String newPassword) {

        if(newPassword == null || !newPassword.matches(PasswordHelperUtil.MATCHER)){
            //新密码不等于空且必须符合规定的正则表达式
            return 1;
        }

        User user = userDao.getUserByTag((Integer) SecurityUtils.getSubject().getPrincipal(),
                null,null, null);
        if(!PasswordHelperUtil.getEncryptPassword(user.getSalt(), oldPassword).equals(user.getPassword())){
            return 2;
        }
        String newSalt = PasswordHelperUtil.getSalt();
        newPassword = PasswordHelperUtil.getEncryptPassword(newSalt, newPassword);
        user.setSalt(newSalt);
        user.setPassword(newPassword);
        userDao.changePwd(user);
        return 0;
    }
}
