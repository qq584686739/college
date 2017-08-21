package com.wl.college.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户收藏
 * Created by DIY on 2017/8/17.
 */
public class UserCollection implements Serializable {
    private Integer id;// 主键
    private Integer userId; //用户id
    private Integer resourceId;//z资源id
    private Date createTime;//创建时间

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
