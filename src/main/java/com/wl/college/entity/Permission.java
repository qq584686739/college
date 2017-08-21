package com.wl.college.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限
 * Created by yugoh on 2017/5/18.
 */
public class Permission implements Serializable {
    private Integer id;    //id
    private String permission;    //名
    private String description;    //描述
    private Integer pid;//父id
    private String pids;    //父连
    private Date createTime;    //创建时间
    private Date updateTime;    //更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
