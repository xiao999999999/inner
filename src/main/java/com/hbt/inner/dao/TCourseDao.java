package com.hbt.inner.dao;

import com.hbt.inner.entity.TCourse;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
public interface TCourseDao {

    int save(@Param("entity") TCourse entity);

    int saveBatch(@Param("entities") List<TCourse> entities);

    int update(@Param("entity") TCourse entity);

    List<TCourse> getById(@Param("id") String id, @Param("availData") int availData);

    int deleteById(String id, @Param("operator") String operator);



}