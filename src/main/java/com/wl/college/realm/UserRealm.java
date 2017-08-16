package com.wl.college.realm;

import com.wl.college.shiro.RetryLimitHashedCredentialsMatcher;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 管理员登录验证器
 */
@Component
public class UserRealm extends AuthorizingRealm {

//    @Autowired
//    private UserService userService;

    @Autowired
    private RetryLimitHashedCredentialsMatcher credentialsMatcher;

    @Override
    public String getName() {
        return "userRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        try {
//            Integer id = Integer.parseInt(principals.getPrimaryPrincipal().toString());     //得到id
//            authorizationInfo.setRoles(userService.findRoleNamesByUserId(id));        //授予角色
//            authorizationInfo.setStringPermissions(userService.findPermissionsNameById(id));      //授予权限(permission.name)
//        } catch (Exception e) {
//            throw new RuntimeException(Constants.NOT_FOUND_USER);
//        }
//        return authorizationInfo;
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        UsernamePasswordUsertypeToken usernamePasswordUsertypeToken = (UsernamePasswordUsertypeToken) token;
//        if (usernamePasswordUsertypeToken.getRank().equals("user")) {
//
//            Integer id = Integer.parseInt(token.getPrincipal().toString());
//            User user = userService.findById(id);
//            if (user == null) {
//                //异常需要处理
//                throw new RuntimeException(Constants.NOT_FOUND_USER);
//            }
//
//            //账号存在的情况下
//            if (user.getState().equals("1")) {
//                //账号被冻结
//                throw new RuntimeException("该客户账号已冻结，请联系管理员！");//需要处理
//            }
//
//            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                    user.getId(),       //用户名
//                    user.getPassword(), //密码
//                    getName()           //realm name
//            );
//
//            return authenticationInfo;
//        } else {
//            return null;
//        }
        return null;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
