package com.wl.college.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by DIY on 2017/6/12.
 */
public class UsernamePasswordUsertypeToken extends UsernamePasswordToken {

    private String rank;

    public UsernamePasswordUsertypeToken(Integer id, String password, String rank) {

        super(id + "", password);

        if (rank != null && rank.length() > 0) {
            setRank(rank);
        }
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}