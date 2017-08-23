package com.wl.college.entity;

import java.io.Serializable;
import java.util.Date;

/**购物车
 * Created by DIY on 2017/8/17.
 */
public class ShoppingCart implements Serializable {
    private Integer id;             //自增主键id
    private Integer userId;         //用户id
    private Integer courseId;       //资源id
    private String type;            //类型
    private Date createTime;        //创建时间

    private Course course;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
