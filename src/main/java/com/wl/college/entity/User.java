package com.wl.college.entity;

import java.util.Date;

/**
 * 用户表
 * Created by yugoh on 2017/5/19.
 */
public class User {
    private Integer id;    //id
    private String name;    //姓名
    private String password;    //密码
    private String email;    //邮箱
    private String phone;    //手机
    private String state;    //状态(0.正常   1.冻结)
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
