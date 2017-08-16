package com.wl.college.entity;

import java.util.Date;

/**
 * Created by DIY on 2017/8/16.
 */
public class Notice {
    private Integer id;             //自增主键id
    private String title;           //通知主题
    private String content;         //通知主要内容
    private Integer fromId;         //发通知人id
    private Integer toId;           //收通知人id
    private String state;           //状态0：未读，1：已读
    private Date createTime;        //创建时间

    public Notice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
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
}
