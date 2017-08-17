package com.wl.college.entity;

/**
 * Created by DIY on 2017/8/17.
 */
public class UserCollection {
    private Integer id;
    private Integer userId;
    private Integer resourceId;

    public UserCollection() {
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
}
