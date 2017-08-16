package com.wl.college.service.impl;

import com.wl.college.entity.User;
import com.wl.college.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

//    @Resource
//    private UserDao userDao;
//    @Resource
//    private AccessLogDao accessLogDao;

    /**
     * 创建用户
     *
     * @param user
     */
    @Override
    public void createUser(User user) {
//        userDao.createUser(user);
//        accessLogDao.userAdd(new AccessUserLog((Integer) SecurityUtils.getSubject().getPrincipal(), LogUtil.createUser(user)));            //操作日志
        return ;
    }

    /**
     * 更新user
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
//        userDao.updateUser(user);
//        accessLogDao.userAdd(new AccessUserLog((Integer) SecurityUtils.getSubject().getPrincipal(), LogUtil.updateUser(user)));            //操作日志
        return ;
    }

    /**
     * 删除一个用户
     *
     * @param userId
     * @return
     */
    @Override
    public void deleteUser(Integer userId) {
//        userDao.deleteUser(userId);
//        accessLogDao.userAdd(new AccessUserLog((Integer) SecurityUtils.getSubject().getPrincipal(),
//                LogUtil.deleteUser(userId)));                //操作日志
        return ;
    }

    /**
     * 修改密码
     *
     * @param id
     * @param oldPassword
     * @param newPassword
     */
    @Override
    public void changePassword(Integer id, String oldPassword, String newPassword) {
//        //改密码
//        User user = null;
//        if (id != null) {
//            user = userDao.findById(id);
//        }
//        if (user == null) {
//            throw new RuntimeException(Constants.NOT_FOUND_USER);
//        } else {
//            if (!user.getPassword().equals(oldPassword)) {
//                //原密码错误
//                throw new RuntimeException(Constants.ERROR_MODIFY_PASSWORD);
//            }
//            if (newPassword != null) {
//                user.setPassword(newPassword);      //设置新密码
//                userDao.updateUser(user);          //更新
//                accessLogDao.userAdd(new AccessUserLog((Integer) SecurityUtils.getSubject().getPrincipal(),
//                        LogUtil.userChangePassword(id)));        //操作日志
//            }
//        }
        return ;
    }

    /**
     * 根据用户名查找其角色
     * @param id
     * @return
     */
    @Override
    public Set<String> findRoleNamesByUserId(Integer id) {
//        return userDao.findRoleNamesByUserId(id);
        return null;
    }


    /**
     * 找到部分用户
     * @param user 索引的user条件
     * @param offset 开始数目
     * @param limit 需要的条数
     * @return
     */
    @Override
    public List<User> findSome(User user, String role, Integer offset, Integer limit) {
//        return userDao.findSome(user, role, offset, limit);
        return null;
    }

    /**
     * 根据用户名找到permission的alias
     * @param id
     * @return
     */
    @Override
    public Set<String> findPermissionsAliasById(Integer id) {
//        return userDao.findPermissionsAliasById(id);
        return null;
    }

    /**
     * 根据userid找到user
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
//        if (id == null) {
//            return null;
//        }
//        return userDao.findById(id);
        return null;
    }

    /**
     * 根据userid找到permission.name集合
     * @param id
     * @return
     */
    @Override
    public Set<String> findPermissionsNameById(Integer id) {
//        return userDao.findPermissionsNameById(id);
        return null;
    }

    /**
     * 更新user_role
     * @param userId
     * @param roleList
     */
    @Override
    public void updateUserRole(Integer userId, List<Integer> roleList) {
//        userDao.deleteUserRole(userId);
//        //再重新分配
//        if (roleList != null && roleList.size() > 0) {
//            userDao.createUserRole(userId, roleList);
//        }
//        //数据库日志
//        accessLogDao.userAdd(new AccessUserLog(
//            (Integer) SecurityUtils.getSubject().getPrincipal(), LogUtil.updateUserRole(roleList))
//        );

        return ;
    }

    /**
     * 冻结该账户
     *
     * @param state
     */
    @Override
    public void banState(Integer id, String state) {
//        userDao.banState(id, state);
        return ;
    }

    /**
     * 根据userId获得roleIds
     * @param userId
     * @return
     */
    @Override
    public List<Integer> findRoleIdsByUserId(Integer userId) {
//        return userDao.findRoleIdsByUserId(userId);
        return null;
    }

    /**
     * 更新userState
     * @param userId
     * @param state
     */
    @Override
    public void updateState(Integer userId, String state) {
//        if (!state.equals("1") && !state.equals("0")) {
//            throw new RuntimeException(Constants.UPDATE_USER_STATE_ERROR);
//        }
//        userDao.updateState(userId, state);
        return ;
    }


    /**
     * 创建user_role
     * @param userId
     * @param roleList
     */
    @Override
    public void createUserRole(Integer userId, List<Integer> roleList) {
//        if (roleList != null && roleList.size() > 0) {
//            userDao.createUserRole(userId, roleList);
//        }
//        //数据库日志
//        accessLogDao.userAdd(new AccessUserLog(
//                (Integer) SecurityUtils.getSubject().getPrincipal(),
//                LogUtil.createUserRole(userId,roleList))
//        );
        return ;
    }

}
