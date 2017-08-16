package com.wl.college.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * 匹配器
 */
@Component("credentialsMatcher")
public class RetryLimitHashedCredentialsMatcher extends SimpleCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;


    @Autowired
    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        System.out.println("进来密码匹配器...");
        //防止登录过多，密码缓存
//        String username = (String)token.getPrincipal();
//        //retry count + 1
//        AtomicInteger retryCount = passwordRetryCache.get(username);
//        if(retryCount == null) {
//            retryCount = new AtomicInteger(0);
//            passwordRetryCache.put(username, retryCount);
//        }
//        if(retryCount.incrementAndGet() > 5) {
//            //if retry count > 5 throw
//            throw new ExcessiveAttemptsException();
//        }
//
//        boolean matches = super.doCredentialsMatch(token, info);
//        if(matches) {
//            //clear retry count
//            passwordRetryCache.remove(username);
//        }
////        return matches;

        boolean isTrue = super.doCredentialsMatch(token, info);

        System.out.println("密码是否正确：" + isTrue);

        return isTrue;
//        Object tokenCredentials = getCredentials(token);
//        Object accountCredentials = getCredentials(info);
//        return equals(tokenCredentials, accountCredentials);

    }
}
