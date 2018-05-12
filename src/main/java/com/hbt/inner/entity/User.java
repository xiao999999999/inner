package com.hbt.inner.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity {

    /**
    *
    */
    private int id;

    /**
    *登录用户名
    */
    private String realname;

    /**
    *真实姓名
    */
    private String username;

    /**
    *密码
    */
    private String password;

    /**
    *用户类型0(default)/1:普通用户/管理员
    */
    private Boolean type;

    /**
    *性别
    */
    private Boolean gender;

    /**
    *头像
    */
    private String header;

    /**
    *手机号码
    */
    private String mobile;

    /**
    *
    */
    private Date birthday;

    /**
    *头衔
    */
    private String title;

    /**
    *微信号
    */
    private String wechatId;

    /**
    *qq号
    */
    private String qq;

    /**
    *是否删除0(default)/1:否/是
    */
    private Boolean sysDelelte;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getRealname() {
        return this.realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getType() {
        return this.type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
    public Boolean getGender() {
        return this.gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getWechatId() {
        return this.wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }
    public String getQq() {
        return this.qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setSysDelelte(Boolean sysDelelte) {
        this.sysDelelte = sysDelelte;
    }

}