package com.hbt.inner.entity;
/**
* 描述：
* @author Json
* @date 2018-05-11
*/
public class CourseSection extends BaseEntity {

    /**
    *
    */
    private int id;

    /**
    *用户id
    */
    private int userId;

    /**
    *课程id
    */
    private int courseId;

    /**
    *章节id
    */
    private int sectionId;

    /**
    *状态：0-学习中；1-学习结束
    */
    private int status;

    /**
    *进度百分比
    */
    private int rate;

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
    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public int getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getRate() {
        return this.rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    public int getSysDelelte() {
        return this.sysDelelte;
    }

    public void setSysDelelte(int sysDelelte) {
        this.sysDelelte = sysDelelte;
    }

}