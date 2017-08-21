package com.wl.college.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DIY on 2017/8/16.
 */
public class Param implements Serializable {
    private Integer id;
    private String volume; //值
    private Integer deptId;//平台id
    private String type;//类型
    private Date createTime;
    private Date updateTime;

    public Param() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
