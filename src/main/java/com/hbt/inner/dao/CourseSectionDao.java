package com.hbt.inner.dao;

import com.hbt.inner.entity.CourseSection;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
public interface CourseSectionDao {

    int save(@Param("entity") CourseSection entity);

    int saveBatch(@Param("entities") List<CourseSection> entities);

    int update(@Param("entity") CourseSection entity);

    List<CourseSection> getById(@Param("id") String id, @Param("availData") int availData);

    int deleteById(String id, @Param("operator") String operator);



}