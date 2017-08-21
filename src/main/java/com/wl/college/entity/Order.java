package com.wl.college.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DIY on 2017/8/16.
 */
public class Order implements Serializable {
    private Integer id;         //主键id
    private String type;        //类型
    private Integer resourceId; //资源、课程类型
    private String state;       //状态（0成功 1未支付 2取消订单）
    private Date updateTime;    //更新时间
    private Date createTime;    //创建时间
    private Integer userId;     //用户id
    private Double credits;    //所需积分
    private Double amount;     //钱

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", resourceId=" + resourceId +
                ", state='" + state + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", credits=" + credits +
                ", amount=" + amount +
                '}';
    }
}
