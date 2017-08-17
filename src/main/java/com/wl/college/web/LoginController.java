package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.entity.Role;
import com.wl.college.enums.Constants;
import com.wl.college.realm.UsernamePasswordUsertypeToken;
import com.wl.college.service.RoleService;
import com.wl.college.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public LoginController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

//    @Resource
//    private AccountService accountService;

    /*
     * 未登录访问接口提示没有登录；
     * 已经登录访问接口提示登陆成功；
     * 被踢出后访问任意需要登录的资源跳转到该接口提示被踢出，请重新登录；
     * 账号在异地登录被挤出访问任意需要登录的资源跳转到该接口，请从新登录；
     *
     * @param request
     * @param response
     * @return 若是已经登陆成功的则返回true，没有登录或者
     */
//    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
//    public BaseResult<Object> login_get(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("login进来了");
//        String info = Constants.NOT_LOGIN;
//        boolean isLogin;
//        try {
//            isLogin = SecurityUtils.getSubject().isAuthenticated();
//            response.setStatus(Constants.NOT_LOGIN_RESPONSE_STATE);
//            if (isLogin) {
//                info = Constants.LOGIN_SUCCESS;
//                response.setStatus(Constants.GOOD_RESPONSE_STATE);
//            }
//            if (request.getParameter("kickout") != null) {      //被挤掉的时候转发带着kickout=1
//                info = Constants.DIFFERENT_ADDRESS_LOGIN;
//                response.setStatus(Constants.DIFFERENT_ADDRESS_RESPONSE_STATE);
//            } else if (request.getParameter("forceLogout") != null) {
//                info = Constants.KICKOUT;
//                response.setStatus(Constants.KICKOUT_RESPONSE_STATE);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new BaseResult<Object>(false, info);
//        }
//        return new BaseResult<Object>(isLogin, info);
//    }


    /**
     * 统一登录
     *
     * @param loginName         登录名（phone or email）
     * @param password   密码
     * @param rememberMe 记住我
     * @return BaseResult<Object>
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public BaseResult<Object> login(String loginName, String password, String rememberMe) {
        log.info("invoke----------/login.POST");
        try{
            boolean remember = rememberMe != null && rememberMe.equals("true");
            Subject subject = SecurityUtils.getSubject();
            String loginFlag = loginName==null?"": loginName.contains("@") ?"email":"phone";       //判断loginName是否有@，有@则是邮箱登录，没有则是手机号登录
            UsernamePasswordUsertypeToken token = new UsernamePasswordUsertypeToken(loginName, password, loginFlag);
            token.setRememberMe(remember);      //设置记住我

            subject.login(token);           //登录

            boolean isLogin = subject.isAuthenticated();
            if (isLogin) {
                //登录成功，返回角色
                List<Role> roles;
                if(loginFlag.equals("email")){
                    //邮箱登录
                    roles = userService.hasRoles(null, loginName, null, null);
                }else{
                    //手机号登录
                    roles = userService.hasRoles(null, null, loginName, null);
                }
                return new BaseResult<>(true, roles);
            }else{
                //登录失败
                return new BaseResult<>(false, "登录失败（到时候以错误代码替代）");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new BaseResult<>(false, "登录失败（到时候以错误代码替代）");
        }
    }

    /**
     * 统一退出登录
     * @return BaseResult<Object>
     */
    @RequiresUser
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseResult<Object> logout() {
        log.info("invoke----------/logout.GET");
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        } else {
            return new BaseResult<>(false, Constants.ERROR_LOGOUT);
        }
        return new BaseResult<>(true, null);
    }
}
