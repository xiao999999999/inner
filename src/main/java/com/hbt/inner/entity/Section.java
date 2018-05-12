package com.hbt.inner.entity;

import java.util.*;
import java.math.BigDecimal;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
public class Section extends BaseEntity {

    /**
    *
    */
    private int id;

    /**
    *归属课程id
    */
    private int courseId;

    /**
    *父章节id，（只有2级）
    */
    private int parentId;

    /**
    *章节名称
    */
    private String name;

    /**
    *排序
    */
    private int sort;

    /**
    *时长
    */
    private String time;

    /**
    *课程地址
    */
    private String videoUrl;

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
    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getSort() {
        return this.sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    public int getSysDelelte() {
        return this.sysDelelte;
    }

    public void setSysDelelte(int sysDelelte) {
        this.sysDelelte = sysDelelte;
    }

}