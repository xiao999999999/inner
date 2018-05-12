package com.hbt.inner.entity;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
public class Ware extends BaseEntity {

    /**
    *
    */
    private int id;

    /**
    *课件名称
    */
    private String name;

    /**
    *归属课程id
    */
    private int courseId;

    /**
    *图片
    */
    private String picture;

    /**
    *课件描述
    */
    private String brief;

    /**
    *是否删除0(default)/1:否/是
    */
    private int sysDelelte;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getBrief() {
        return this.brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
    public int getSysDelelte() {
        return this.sysDelelte;
    }

    public void setSysDelelte(int sysDelelte) {
        this.sysDelelte = sysDelelte;
    }

}