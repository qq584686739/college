package com.wl.college.entity;

import java.util.Date;

/**
 * Created by DIY on 2017/8/17.
 */
public class UserResource {
    private Integer id;                     //自增主键id
    private Integer userId;                 //用户id
    private Integer resourceId;             //资源id
    private String state;                   //状态，0：未观看，1：已观看
    private Integer viewTime;               //观看次数
    private Date expiration_date;       //到期时间

    public UserResource() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getViewTime() {
        return viewTime;
    }

    public void setViewTime(Integer viewTime) {
        this.viewTime = viewTime;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }
}
