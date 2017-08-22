package com.wl.college.entity;

import java.io.Serializable;
import java.util.Date;

/**购物车
 * Created by DIY on 2017/8/17.
 */
public class ShoppingCart implements Serializable {
    private Integer id;             //自增主键id
    private Integer userId;         //用户id
    private Integer resourceId;     //资源id
    private String type;            //类型
    private Date create_time;       //创建时间

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

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
