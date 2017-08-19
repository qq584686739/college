package com.wl.college.entity;

import java.util.Date;

/**
 * Created by DIY on 2017/8/16.
 */
public class Course {
    private Integer id;
    private String name;            //课程名
    private Double price;        //价钱
    private Integer deptId;     //所属平台id
    private String icon;        //课程图标
    private Integer pid;        //上级课程
    private String details;     //详情
    private String description; //描述
    private String pids;        //上级依赖连
    private Integer number;      //产品数量
    private Date updateTime;    //更新时间
    private Date createTime;    //创建时间
    private Integer pointId; //指向id 为null就是父课 ，其他都是下方的课

    public Course() {
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", deptId=" + deptId +
                ", icon='" + icon + '\'' +
                ", pid=" + pid +
                ", details='" + details + '\'' +
                ", description='" + description + '\'' +
                ", pids='" + pids + '\'' +
                ", number=" + number +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}
