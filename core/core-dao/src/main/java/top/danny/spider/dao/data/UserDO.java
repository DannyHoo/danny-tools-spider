package top.danny.spider.dao.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDO
 * @Copyright: Copyright (c) 2016
 * @Description: 用户
 * @Company: lxjr.com
 * @Created on 2017-01-19 22:26:37
 */
@Entity
@Table(name="t_user")
public class UserDO extends BaseEntity {

    @Column(name = "userName",nullable = false)
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "portrait")
    private String portrait;

    @Column(name="realName")
    private String realName;

    @Column(name="sex")
    private int sex;

    @Column(name="idCardNo")
    private String idCardNo;

    @Column(name="mobileNo")
    private String mobileNo;

    @Column(name="email")
    private String email;

    @Column(name="birthday")
    private Date birthday;

    @Column(name="address")
    private String address;

    @Column(name="age")
    private Integer age;

    public String getUserName() {
        return userName;
    }

    public UserDO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPortrait() {
        return portrait;
    }

    public UserDO setPortrait(String portrait) {
        this.portrait = portrait;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public UserDO setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public int getSex() {
        return sex;
    }

    public UserDO setSex(int sex) {
        this.sex = sex;
        return this;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public UserDO setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public UserDO setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public UserDO setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserDO setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserDO setAge(Integer age) {
        this.age = age;
        return this;
    }
}
