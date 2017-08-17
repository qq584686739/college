package com.wl.college.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by DIY on 2017/6/12.
 */
public class UsernamePasswordUsertypeToken extends UsernamePasswordToken {

    private String loginFlag;

    public UsernamePasswordUsertypeToken(String loginName, String password, String loginFlag) {

        super(loginName, password);

        if (loginFlag != null && loginFlag.length() > 0) {
            setLoginFlag(loginFlag);
        }
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }
}