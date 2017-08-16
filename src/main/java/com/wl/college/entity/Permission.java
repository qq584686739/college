package com.wl.college.entity;

import java.util.Date;

/**
 * 权限
 * Created by yugoh on 2017/5/18.
 */
public class Permission {
    private Integer id;    //id
    private String name;    //名(后端用)
    private String alias;    //昵称(前端用)
    private String note;    //说明
    private Date createTime;    //创建时间
    private Date updateTime;    //更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
