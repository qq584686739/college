package com.wl.college.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * 匹配器
 * Created by XJH on 2017/8/21.
 */
@Component("credentialsMatcher")
public class MyHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private final String hashAlgorithmName = "md5";
    private final Integer hashIterations = 2;
    private final Boolean storedCredentialsHexEncoded = true;


    MyHashedCredentialsMatcher(){
        super.setHashAlgorithmName(hashAlgorithmName);
        super.setHashIterations(hashIterations);
        super.setStoredCredentialsHexEncoded(storedCredentialsHexEncoded);
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        System.out.println("进入匹配器");
        return super.doCredentialsMatch(token, info);
    }
}
