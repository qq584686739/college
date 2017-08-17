package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.enums.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class LoginController {

//    @Resource
//    private UserService userService;

//    @Resource
//    private AccountService accountService;

    /**
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
     * 统一登录接口
     * @param object user的id或者account的email
     * @param password  密码
     * @param rememberMe    是否记住我，可以不传该字段，或者传空，true，false
     * @param rank  职位，user或account
     * @return
     */


    /**
     * 统一登录
     *
     * @param id         管理员的id
     * @param email      用户的邮箱
     * @param password   密码
     * @param rememberMe 记住我
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public BaseResult<Object> login(Integer id, String email, String password, String rememberMe) {

        try{

            boolean remember = rememberMe != null && rememberMe.equals("true");
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(String.valueOf(id), password);
            token.setRememberMe(remember);      //设置记住我

            subject.login(token);           //登录

        }catch (Exception e){

        }


        return null;
//        try {
//            Account account = null;
//            if (id == null && email != null) {
//                account = accountService.getAccountByTag(null, email, null);
//                if (account != null) {
//                    id = account.getId();
//                }
//                if (id == null) {
//                    return new BaseResult<>(false, Constants.LOGIN_FAIL);
//                }
//            }
//
//            if (rank == null || !rank.equals("user") && !rank.equals("account")) {
//                return new BaseResult<>(false, Constants.RANK_ERROR);
//            }
//
//            boolean remember = rememberMe != null && rememberMe.equals("true");
//            Subject subject = SecurityUtils.getSubject();
//            UsernamePasswordUsertypeToken token = new UsernamePasswordUsertypeToken(id, password, rank);
//            token.setRememberMe(remember);      //设置记住我
//
//            subject.login(token);           //登录
//
//            boolean isLogin = subject.isAuthenticated();
//            if (isLogin) {
//                if (rank.equals("user")) {
//                    Set<String> permissions = userService.findPermissionsAliasById(id);      //根据id找权限
//                    subject.getSession().setAttribute("rank", "user");
//                    return new BaseResult<>(true, permissions);
//                } else if (rank.equals("account")) {
//                    subject.getSession().setAttribute("rank", "account");                   //在session设置是客户，在session管理需要用到
//                    // 现在需求变了：可以看到所有人在线并且管理所有人
//                    return new BaseResult<>(true, id);     //客户登陆成功返回id
//                }
//            }
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//            return new BaseResult<>(false, e.getMessage());         //返回响应的信息
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new BaseResult<>(false, Constants.LOGIN_FAIL);
    }

//    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
//    public BaseResult<Object> logout() {
//
//        Subject subject = SecurityUtils.getSubject();
//        if (subject.isAuthenticated()) {
//            subject.logout();
//        } else {
//            return new BaseResult<>(false, Constants.ERROR_LOGOUT);
//        }
//
//        //退出返回true和error
//        return new BaseResult<>(true, null);
//    }


    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @RequiresUser
    public BaseResult<Object> test() {

        System.out.println("test");

        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        } else {
            return new BaseResult<Object>(false, Constants.ERROR_LOGOUT);
        }

        //退出返回true和error
        return new BaseResult<Object>(true, null);
    }


}
