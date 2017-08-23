package com.wl.college.entity;

import java.util.Date;

/**
 * Created by DIY on 2017/8/22.
 */
public class Authentication {
    private Integer id;
    private String fullName;        //真是姓名
    private String city;            //省
    private String town;            //市
    private String address;         //地址
    private String idCard;          //身份证
    private String idCardFront;     //身份证前面
    private String idCardBack;      //身份证后面
    private String idCardWith;      //手持
    private String state;           //状态
    private Date createTime;        //创建时间
    private Date updateTime;        //更新
    private String bankCard;        //银行卡
    private String bankCardFront;   //正面
    private String bankCardBack;    //反面
    private String photo;
    private String branch;
    private Integer userId;

    private User user;

    public Authentication() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCardFront() {
        return idCardFront;
    }

    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront;
    }

    public String getIdCardBack() {
        return idCardBack;
    }

    public void setIdCardBack(String idCardBack) {
        this.idCardBack = idCardBack;
    }

    public String getIdCardWith() {
        return idCardWith;
    }

    public void setIdCardWith(String idCardWith) {
        this.idCardWith = idCardWith;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getBankCardFront() {
        return bankCardFront;
    }

    public void setBankCardFront(String bankCardFront) {
        this.bankCardFront = bankCardFront;
    }

    public String getBankCardBack() {
        return bankCardBack;
    }

    public void setBankCardBack(String bankCardBack) {
        this.bankCardBack = bankCardBack;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
