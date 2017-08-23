package com.wl.college.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by DIY on 2017/8/16.
 */
public class DeptTicket implements Serializable {
    private Integer id;         //自增主键id
    private String name;        //名称
    private String type;        //类型
    private String url;         //资源路径
    private Integer deptId;     //平台id
    private Date createTime;    //创建时间

    public DeptTicket() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
