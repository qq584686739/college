package com.wl.college.entity;

/**
 * Created by DIY on 2017/8/17.
 */
public class ShoppingCart {
    private Integer id;
    private Integer userId;//用户id
    private Integer resourceId;//资源id
    private String type;//类型

    public ShoppingCart() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
