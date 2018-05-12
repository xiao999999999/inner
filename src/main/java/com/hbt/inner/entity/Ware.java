package com.hbt.inner.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.math.BigDecimal;

/**
 * 描述：
 * @author Json
 * @date 2018-05-11
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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



}