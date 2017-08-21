package com.wl.college.entity;

import java.io.Serializable;

/**
 * Created by DIY on 2017/8/17.
 */
public class UserCourse implements Serializable {
    private Integer id;//自增主键
    private Integer userId;//用户id
    private Integer courseId;//课程号
    private Integer schedule;//进度
    private Integer isTest;//是否可用考试

    public UserCourse() {
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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    public Integer getIsTest() {
        return isTest;
    }

    public void setIsTest(Integer isTest) {
        this.isTest = isTest;
    }
}
