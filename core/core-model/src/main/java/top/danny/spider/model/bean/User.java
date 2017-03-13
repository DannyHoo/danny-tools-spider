package top.danny.spider.model.bean;

import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: User
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-18 15:31:23
 */
public class User extends BaseBean {
    private String userName;

    private String password;

    private String portrait;

    private String realName;

    private int sex;

    private String idCardNo;

    private String mobileNo;

    private String email;

    private Date birthday;

    private String address;

    private Long districtId;

    private Integer age;

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPortrait() {
        return portrait;
    }

    public User setPortrait(String portrait) {
        this.portrait = portrait;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public User setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public int getSex() {
        return sex;
    }

    public User setSex(int sex) {
        this.sex = sex;
        return this;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public User setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public User setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public User setDistrictId(Long districtId) {
        this.districtId = districtId;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }
}
