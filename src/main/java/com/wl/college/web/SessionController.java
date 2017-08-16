package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.enums.Constants;
import com.wl.college.enums.OperationType;
import com.wl.college.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;


@CrossOrigin
@RestController
@RequestMapping("/sessions")
@RequiresPermissions(OperationType.SESSION_ALL)
public class SessionController {
    @Resource
    private SessionDAO sessionDAO;
//    @Resource
//    private UserService userService;
//    @Resource
//    private AccountService accountService;

    /**
     * 管理员查看在线客户和管理员
     *
     * @return  BaseResult 返回所有在线的管理员和客户
     */
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public BaseResult<Object> list() {
//        List<Map<String, Object>> result = new ArrayList<>();
//        try{
//            Collection<Session> sessionAll = sessionDAO.getActiveSessions();        //得到所有的session
//            //遍历一下，删掉没有登录的
//            for (Session sessionTemp : sessionAll) {
//                Serializable sessionId = sessionTemp.getId();               //得到每一个sessionId
//                Subject requestSubject = new Subject.Builder().sessionId(sessionId).buildSubject();     //根据sessionId得到subject
////                if (requestSubject.isAuthenticated() && sessionTemp.getAttribute("rank") != null && sessionTemp.getAttribute("rank").equals("account")) {
//                if (requestSubject.isAuthenticated()) {
//                    //登录成功的客户
////                    if (SecurityUtils.getSubject().getSession().getId().equals(sessionTemp.getId())) {
////                        //是自己，就continue
////                        continue;
////                    }
//                    Map<String, Object> map = new HashMap<>();
//
//                    //不是自己才添加
//                    map.put("sessionId", sessionTemp.getId());
//                    PrincipalCollection principalCollection =
//                            (PrincipalCollection) sessionTemp.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
//
//                    if(sessionTemp.getAttribute("rank").equals("user")){
//                        //管理管理员
//                        User user = userService.findById((Integer)principalCollection.getPrimaryPrincipal());
//                        map.put("id", user.getId());
//                        map.put("isBan", user.getState());
//
//                    }else if(sessionTemp.getAttribute("rank").equals("account")){
//                        //管理客户
//                        Account account = accountService.getAccountByTag((Integer)principalCollection.getPrimaryPrincipal(),
//                                null, null);
//                        if(account != null){
//                            map.put("email", account.getEmail());
//                            map.put("isBan", account.getState());
//                        }
//                    }
//
//                    map.put("isForceLogout", sessionTemp.getAttribute(Constants.SESSION_FORCE_LOGOUT_KEY) != null);
//
//                    result.add(map);
//                } else {
//                    //这是没有登录的用户处理（没有登录的客户访问的话也会存在session，但是我们只获取已经登录的用户）
//                }
//            }
//        }catch (Exception e){
//            return new BaseResult<>(false, null);
//        }
//        return new BaseResult<>(true, result);


//      返回在线
        return null;

    }

    /**
     * 管理员踢人
     *
     * @param sessionId 传入的sessionID
     * @return boolean 踢人成功返回true，失败返回false
     */
    @RequestMapping("/{sessionId}/forceLogout")
    public boolean forceLogout(@PathVariable("sessionId") String sessionId) {
//        try {
//            Session session = sessionDAO.readSession(sessionId);            //根据sessionId得到session
//            if (session != null) {
//                session.setAttribute(Constants.SESSION_FORCE_LOGOUT_KEY, Boolean.TRUE);     //踢出session
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;

//        返回踢人是否成功
        return false;
    }


    /**
     * 管理员禁止登录
     *
     * @param sessionId 传入的sessionID
     * @return true：禁止成功，false：禁止失败
     */
    @RequestMapping("/{sessionId}/ban")
    public boolean ban(@PathVariable("sessionId") String sessionId) {

//        String rank = "";
//        try {
//            Session session = sessionDAO.readSession(sessionId);            //根据sessionId得到session
//            if (session != null) {
//                rank = (String)session.getAttribute("rank");
//                session.setAttribute(Constants.SESSION_FORCE_LOGOUT_KEY, Boolean.TRUE);     //先踢出会话
//            }
//            Subject subject = new Subject.Builder().sessionId(sessionId).buildSubject();        //根据sessionId得到subject
//            switch (rank) {
//                case "account":
//                    accountService.banState((Integer) subject.getPrincipal(), "1");      //禁止客户登录
//
//                    System.out.println("已禁止客户登录！");
//                    break;
//                case "user":
//                    userService.banState((Integer) subject.getPrincipal(), "1");     //禁止管理员登录
//
//                    System.out.println("已禁止管理员登录");
//                    break;
//                default:
//                    return false;
//            }
//        } catch (Exception e) {
//            System.out.println("禁止user/account报错！");
//            e.printStackTrace();
//            return false;
//        }
//        return true;

//        返回禁止登录是否成功
        return false;
    }
}
