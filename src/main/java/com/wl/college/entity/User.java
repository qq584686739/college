package com.wl.college.entity;

import java.util.Date;

/**
 * 用户表
 * Created by yugoh on 2017/5/19.
 */
public class User {
    private Integer id;
    private String name;//姓名
    private String referralCode;//推荐码
    private String password;//密码
    private String salt;//盐
    private String mail;//邮箱
    private String phone;//电话
    private String fullName;//真是姓名
    private String country;//国家
    private String city;//省
    private String town;//市
    private String address;//地址
    private String idCard;//身份证
    private String idCardFront;//身份证前面
    private String idCardBack;//身份证后面
    private String idCardWith;//手持
    private Integer pid;//推荐人
    private String pids;//推荐人连
    private String state;//状态
    private Date createTime;//创建时间
    private Date updateTime;//更新
    private String bankCard;//银行卡
    private String bankCardFront;//正面
    private String bankCardBack;//反面
    private String bankCardState;//银行卡状态
    private String idCardState;//身份证状态
    private Date birthdate;//出生日期
    private String gender;//性别
    private Integer deptId;//所属平台
    private Integer signInDay;//签到天数
    private Date lastSignIn;//最后签到时间

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getSignInDay() {
        return signInDay;
    }

    public void setSignInDay(Integer signInDay) {
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
