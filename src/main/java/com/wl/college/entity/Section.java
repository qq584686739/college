package com.wl.college.entity;

/**
 * Created by DIY on 2017/8/16.
 */
public class Section {
    private Integer id;
    private String name;//姓名
    private Integer course_id;//课程号
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

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
