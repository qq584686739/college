package com.wl.college.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 客户登录验证器
 */
public class AccountRealm extends AuthorizingRealm {

//    @Resource
//    private AccountService accountService;

    @Override
    public String getName() {
        return "accountRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //客户的权限直接返回空(客户)
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        UsernamePasswordUsertypeToken usernamePasswordUsertypeToken = (UsernamePasswordUsertypeToken) token;
//        if (usernamePasswordUsertypeToken.getRank().equals("account")) {
//            Integer id = Integer.parseInt(token.getPrincipal().toString());         //得到登录用户名：id
//            Account account = accountService.getAccountByTag(id, null, null);
//
//            if (account == null) {
//                throw new RuntimeException(Constants.NOT_FOUND_USER);
//            }
//
//            if (account.getState().equals("1")||account.getState().equals("1,1")) {
//                throw new RuntimeException("该客户账号已冻结，请联系管理员！");
//            }
//
//            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                    account.getId(),                //用户名
//                    account.getPassword(),           //密码
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
