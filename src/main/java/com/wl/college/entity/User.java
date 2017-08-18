package com.wl.college.entity;

import java.util.Date;

/**
 * 用户表
 * Created by yugoh on 2017/5/19.
 */
public class User {
    private int id;
    private String name;
    private String referralCode;
    private String password;
    private String salt;
    private String mail;
    private String phone;
    private String fullName;
    private String country;
    private String city;
    private String address;
    private String idCard;
    private String idCardFront;
    private String idCardBack;
    private String idCardWith;
    private int pid;
    private String pids;
    private String state;
    private Date createTime;
    private Date updateTime;
    private String bankCard;
    private String bankCardFront;
    private String bankCardBack;
    private String bankCardState;
    private String idCardState;
    private Date birthdate;
    private String gender;
    private int deptId;
    private int signInDay;
    private Date lastSignIn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
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

    public String getBankCardState() {
        return bankCardState;
    }

    public void setBankCardState(String bankCardState) {
        this.bankCardState = bankCardState;
    }

    public String getIdCardState() {
        return idCardState;
    }

    public void setIdCardState(String idCardState) {
        this.idCardState = idCardState;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getSignInDay() {
        return signInDay;
    }

    public void setSignInDay(int signInDay) {
        this.signInDay = signInDay;
    }

    public Date getLastSignIn() {
        return lastSignIn;
    }

    public void setLastSignIn(Date lastSignIn) {
        this.lastSignIn = lastSignIn;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", referralCode='" + referralCode + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", fullName='" + fullName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", idCard='" + idCard + '\'' +
                ", idCardFront='" + idCardFront + '\'' +
                ", idCardBack='" + idCardBack + '\'' +
                ", idCardWith='" + idCardWith + '\'' +
                ", pid=" + pid +
                ", pids='" + pids + '\'' +
                ", state='" + state + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", bankCard='" + bankCard + '\'' +
                ", bankCardFront='" + bankCardFront + '\'' +
                ", bankCardBack='" + bankCardBack + '\'' +
                ", bankCardState='" + bankCardState + '\'' +
                ", idCardState='" + idCardState + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", deptId=" + deptId +
                ", signInDay=" + signInDay +
                ", lastSignIn=" + lastSignIn +
                '}';
    }
}
