package com.hbt.inner.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 描述：
 *
 * @author Json
 * @date 2018-05-11
 */
@Getter
@Setter
@Builder
public class Course extends BaseEntity {

    /**
     *
     */
    private int id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 归属人
     */
    private String username;

    /**
     * 时长
     */
    private String time;

    /**
     * 图片
     */
    private String picture;

    /**
     * 课程描述
     */
    private String brief;

    /**
     * 学习人数
     */
    private int studyCount;

    /**
     * 评分
     */
    private int score;

    /**
     * 评分人数
     */
    private int scoreCount;

    /**
     * 是否删除0(default)/1:否/是
     */
    private int sysDelelte;


}