package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.Role;
import com.wl.college.entity.User;
import com.wl.college.exception.BizExceptionEnum;
import com.wl.college.exception.BizExceptionMessage;
import com.wl.college.realm.UsernamePasswordUsertypeToken;
import com.wl.college.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 统一登录
     *
     * @param loginName  登录名（phone or email）
     * @param password   密码
     * @param rememberMe 记住我
     * @return BaseResult<Object>
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public BaseResult<Object> login(@RequestParam String loginName, @RequestParam String password, @RequestParam boolean rememberMe) {
        log.info("invoke----------/user/login.POST");
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        String loginFlag = loginName == null ? "" : loginName.contains("@") ? "email" : "phone";       //判断loginName是否有@，有@则是邮箱登录，没有则是手机号登录
        UsernamePasswordUsertypeToken token = new UsernamePasswordUsertypeToken(loginName, password, loginFlag);
        token.setRememberMe(rememberMe);      //设置记住我

        subject.login(token);           //登录

        boolean isLogin = subject.isAuthenticated();
        if (isLogin) {
            //登录成功，返回角色
            List<Role> roles;
            if (loginFlag.equals("email")) {
                //邮箱登录
                roles = userService.hasRoles(null, loginName, null, null);
            } else {
                //手机号登录
                roles = userService.hasRoles(null, null, loginName, null);
            }
            return new BaseResult<>(true, roles);
        } else {
            //登录失败
            return new BaseResult<>(false, "登录失败（到时候以错误代码替代）");
        }
    }


    /**
     * 根据条件获取一部分user
     *
     * @param user       筛选条件user
     * @param offset     起始数
     * @param limit      需要数
     * @param sort_field 排序的字段
     * @param sort_rule  排序的规则
     * @return
     */
    @RequiresUser
    @GetMapping(produces = {"application/json;charset=UTF-8"})
    // TODO: 2017/8/21 必须有查看其它user的权限 
    public BootStrapTableResult list(
            @RequestParam(value = "user", required = false) User user,
            @RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
            @RequestParam(value = "sort", required = false, defaultValue = "id") String sort_field,
            @RequestParam(value = "order", required = false, defaultValue = "ASC") String sort_rule) {
        log.info("invoke----------/user.GET");
        Integer total = userService.findCount(user);
        List<User> list = userService.listUser(user, offset, limit, sort_field, sort_rule);
        return new BootStrapTableResult<>(total, list);
    }


    /**
     * 查找自己的roles
     *
     * @return BaseResult
     */
    @RequiresUser
    @GetMapping(value = "/myselfRoles", produces = {"application/json;charset=UTF-8"})
    public BaseResult mySelfRoles() {
        log.info("invoke----------/user/mySelfRoles.GET");
        Integer id = (Integer) SecurityUtils.getSubject().getPrincipal();
        List<Role> list = userService.hasRoles(id, null, null, null);
        return new BaseResult<>(true, list);
    }

    /**
     * 根据唯一标识（id、email、phone、idCard）查看别人的roles
     *
     * @param id
     * @return BaseResult
     */
    @RequiresUser
    @GetMapping(value = "/otherRoles", produces = {"application/json;charset=UTF-8"})
    // TODO: 2017/8/18 需要有看别人角色的权限
    public BaseResult otherRoles(Integer id,
                                 String email,
                                 String phone,
                                 String idCard) {
        log.info("invoke----------/user/otherRoles.GET");
        List<Role> list = userService.hasRoles(id, email, phone, idCard);
        return new BaseResult<>(true, list);
    }

    /**
     * 自己更新user信息
     *
     * @param user
     * @return BaseResult
     */
    @RequiresUser
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public BaseResult update(@RequestParam User user) {
        log.info("invoke----------/user/update.PUT");
        user.setId((Integer) SecurityUtils.getSubject().getPrincipal());
        userService.updateUser(user);                   //更新user
        return new BaseResult<>(true, user);
    }


    /**
     * 修改其他user的个人信息
     *
     * @param id
     * @param user
     * @return BaseResult
     */
    @RequiresUser
    @RequestMapping(value = "/updateOther", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    // TODO: 2017/8/18 有修改其他user信息的权限
    public BaseResult updateOther(@RequestParam Integer id,
                                  @RequestParam User user) {
        log.info("invoke----------/user/updateOther.PUT");
        user.setId(id);
        userService.updateUser(user);                   //更新user
        return new BaseResult<>(true, user);
    }

    /**
     * 客户注册
     *
     * @param user
     * @param securityCode
     * @return BaseResult
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public BaseResult register(@RequestParam User user,
                               @RequestParam String securityCode) {
        log.info("invoke----------/user/register.POST");
        // TODO: 2017/8/21  securityCode验证
        userService.register(user);
        return new BaseResult<>(true, user);
    }

    /**
     * user查看自己的个人信息
     *
     * @return BaseResult
     */
    @RequiresUser
    @RequestMapping(value = "/getInfo", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseResult getInfo() {
        log.info("invoke----------/user/getInfo.GET");
        return new BaseResult<>(true, userService.getUserByTag((Integer) SecurityUtils.getSubject().getPrincipal(),
                null, null, null));
    }

    /**
     * 查看其它user的个人信息
     *
     * @param id
     * @param email
     * @param phone
     * @param idCard
     * @return BaseResult
     */
    @RequiresUser
    @RequestMapping(value = "/getOtherInfo", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    // TODO: 2017/8/21 需要有查看其它user的权限
    public BaseResult getOtherInfo(Integer id,
                                   String email,
                                   String phone,
                                   String idCard) {
        log.info("invoke----------/user/getInfo.GET");
        return new BaseResult<>(true, userService.getUserByTag(id,
                email, phone, idCard));
    }

    /**
     * user修改自己密码
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequiresUser
    @RequestMapping(value = "/changePwd", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    // TODO: 2017/8/21 需要有查看其它user的权限
    public BaseResult changePwd(@RequestParam String oldPassword,
                                @RequestParam String newPassword) {
        log.info("invoke----------/user/changePwd.PUT");
        userService.changePwd(oldPassword, newPassword);
        return new BaseResult<>(true, null);
    }



    /**
     * 统一退出登录
     *
     * @return BaseResult<Object>
     */
    @RequiresUser
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseResult logout() {
        log.info("invoke----------/user/logout.GET");
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        } else {
            return new BaseResult<>(false, new BizExceptionMessage(BizExceptionEnum.DB_INSERT_RESULT_ERROR));
        }
        return new BaseResult<>(true, null);
    }
}
