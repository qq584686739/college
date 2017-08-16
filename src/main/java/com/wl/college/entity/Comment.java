package com.wl.college.entity;

import java.util.Date;

/**
 * Created by DIY on 2017/8/16.
 */
public class Comment {
    private Integer id;
    private Integer userId; //用户id
    private Integer resourceId;//资源id
    private String content;//评论
    private Integer pid;//该评论所属父评论,0：属于资源下的一级评论
    private Integer deptId;//平台id
    private String  state;//评论状态，0：待审核，1：审核通过， 2：审核失败
    private Date createTime;

    public Comment() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
