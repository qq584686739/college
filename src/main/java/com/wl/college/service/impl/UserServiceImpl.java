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

import java.util.Date;
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
     * @param mail
     * @param phone
     * @param idCard
     * @return User
     */
    @Override
    public User getUserByTag(Integer id, String mail, String phone, String idCard) {
        return userDao.getUserByTag(id, mail, phone, idCard);
    }

    /**
     * 根据唯一标记获得用户的角色
     *
     * @param id
     * @param mail
     * @param phone
     * @param idCard
     * @return List<Role>
     */
    @Override
    public List<Role> hasRoles(Integer id, String mail, String phone, String idCard) {
        return userDao.hasRoles(id, mail, phone, idCard);
    }

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
    @Override
    public List<User> listUser(User user, Integer offset, Integer limit, String sort, String order) {
        return userDao.listUser(user, offset, limit, sort, order);
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
     *
     * @param user
     */
    @Override
    public Integer register(User user) {

        if (user.getPassword() == null || !user.getPassword().matches(PasswordHelperUtil.MATCHER)) {
            //新密码不等于空且必须符合规定的正则表达式
            return 1;
        }

        //设置密码和salt
        String salt = PasswordHelperUtil.getSalt();
        user.setSalt(salt);
        user.setPassword(PasswordHelperUtil.getEncryptPassword(salt, user.getPassword()));
        userDao.register(user);
        return 0;
    }

    /**
     * 修改密码
     *
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return return 0:修改成功
     * return 1:不符合正则规定
     * return 2:oldPassword错误
     * return 3:错误的id找不到指定的user
     */
    @Override
    public Integer changePwd(Integer id, String oldPassword, String newPassword) {

        if (newPassword == null || !newPassword.matches(PasswordHelperUtil.MATCHER)) {
            //新密码不等于空且必须符合规定的正则表达式
            return 1;
        }

        User user = userDao.getUserPwdByTag(id, null, null, null);
        if (user == null) {
            //错误的id找到不到相应的user
            return 3;
        }

        if (!PasswordHelperUtil.getEncryptPassword(user.getSalt(), oldPassword).equals(user.getPassword())) {
            //oldpassword与数据库密码不符，不允许修改
            return 2;
        }

        String newSalt = PasswordHelperUtil.getSalt();                                  //得到一个新的salt
        newPassword = PasswordHelperUtil.getEncryptPassword(newSalt, newPassword);      //得到一个新的password
        user.setSalt(newSalt);                                                          //设置salt
        user.setPassword(newPassword);                                                  //设置password
        userDao.changePwd(user);                                                        //修改密码
        return 0;
    }

    /**
     * 根据唯一标识得到user的密码
     *
     * @param id
     * @param mail
     * @param phone
     * @param idCard
     * @return User
     */
    @Override
    public User getUserPwdByTag(Integer id, String mail, String phone, String idCard) {
        return userDao.getUserPwdByTag(id, mail, phone, idCard);
    }

    /**
     * 更新user_role
     *
     * @param id
     * @param roleList
     */
    @Override
    public void updateUserRole(Integer id, List<Integer> roleList) {
        userDao.deleteUserRole(id);                 //先删除user_role
        userDao.createUserRole(id, roleList);       //再创建user_role
    }

    /**
     * 用户签到
     * @param principal
     * @return
     */
    @Override
    public Integer sign(Integer principal) {

        Long oneDay = 86400000L;                             //一天的时间(毫秒为单位)
        Integer fullGold = 8;                                //签到一天获得最多的金币量

        User user = userDao.findById(principal);
        if(System.currentTimeMillis() - user.getLastSignIn().getTime() > oneDay){
            user.setSignInDay(1);                           //设置连续签到天数为1
            user.setGold(user.getGold() + 1);               //金币+1
        }else{
            user.setSignInDay(user.getSignInDay() + 1);     //设置连续签到天数+1
            if(user.getSignInDay()>=8){
                user.setGold(user.getGold() + fullGold);    //当连续超过8天，签到获得的金币不得超过签到一天获得最多的金币量
            }else{
                //签到天数为 1<X<8 或得到的金币量为签到的天数（这个天数包含本次签到）
                user.setGold(user.getGold() + user.getSignInDay());
            }
        }
        user.setLastSignIn(new Date());                     //更新签到时间

        userDao.update(user, user.getId());                 //金币+1、更新签到时间
        return user.getSignInDay();
    }
}
