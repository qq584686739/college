package com.wl.college.entity;

import java.io.Serializable;

/**
 * Created by DIY on 2017/8/17.
 */
public class UserCourse implements Serializable {
    private Integer id;             //自增主键
    private Integer userId;         //用户id
    private Integer courseId;       //课程号
    private Integer schedule;       //进度
    private Integer test;           //是否可用考试

    private User user;
    private Course course;

    public UserCourse() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }
}
