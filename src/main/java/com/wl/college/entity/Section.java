package com.wl.college.entity;

import java.io.Serializable;

/**
 * Created by DIY on 2017/8/16.
 */
public class Section implements Serializable {
    private Integer id;
    private String name;//姓名
    private Integer courseId;//课程号
    private String description;//描述

    public Section() {
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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
