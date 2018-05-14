package com.hbt.inner.dao;

import com.hbt.inner.entity.Course;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
public interface CourseDao {

    int save(@Param("entity") Course entity);

    int saveBatch(@Param("entities") List<Course> entities);

    int update(@Param("entity") Course entity);

    List<Course> getById(@Param("id") String id, @Param("availData") int availData);

    int deleteById(String id, @Param("operator") String operator);



}