package com.wl.college.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DIY on 2017/8/16.
 */
public class Dept implements Serializable {
    private Integer id;         //自增主键id
    private String name;        //平台名字
    private Integer managerId;  //负责人id
    private String country;     //国家
    private String city;        //城市
    private String town;        //镇、区域
    private String address;     //地址
    private String area;        //面积
    private String license;     //营业执照
    private String bankCard;    //银行卡号
    private Date updateTime;    //更新时间
    private Date createTime;    //创建时间
    private String state;       //状态：0：正常，1：冻结
    private Integer pid;        //上级推荐人
    private String pids;        //上级推荐人连
    private Date expirationTime;    //到期时间
    private String licenseImg; //营业执照照片

    private User manager;

    public Dept() {
    }

    public String getLicenseImg() {
        return licenseImg;
    }

    public void setLicenseImg(String licenseImg) {
        this.licenseImg = licenseImg;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
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

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerId=" + managerId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", license='" + license + '\'' +
                ", bankCard='" + bankCard + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", state='" + state + '\'' +
                ", pid=" + pid +
                ", pids='" + pids + '\'' +
                ", expirationTime=" + expirationTime +
                ", licenseImg='" + licenseImg + '\'' +
                ", manager=" + manager +
                '}';
    }
}
