package com.hbt.inner.entity;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
public class TCourse extends BaseEntity {

    /**
    *
    */
    private int id;

    /**
    *课程名称
    */
    private String name;

    /**
    *归属人
    */
    private String username;

    /**
    *时长
    */
    private String time;

    /**
    *图片
    */
    private String picture;

    /**
    *课程描述
    */
    private String brief;

    /**
    *学习人数
    */
    private int studyCount;

    /**
    *评分
    */
    private int score;

    /**
    *评分人数
    */
    private int scoreCount;

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
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
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
    public int getStudyCount() {
        return this.studyCount;
    }

    public void setStudyCount(int studyCount) {
        this.studyCount = studyCount;
    }
    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScoreCount() {
        return this.scoreCount;
    }

    public void setScoreCount(int scoreCount) {
        this.scoreCount = scoreCount;
    }
    public int getSysDelelte() {
        return this.sysDelelte;
    }

    public void setSysDelelte(int sysDelelte) {
        this.sysDelelte = sysDelelte;
    }

}