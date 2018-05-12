package com.hbt.inner.dao;

import com.hbt.inner.entity.Section;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
public interface SectionDao {

    int save(@Param("entity") Section entity);

    int saveBatch(@Param("entities") List<Section> entities);

    int update(@Param("entity") Section entity);

    List<Section> getById(@Param("id") String id, @Param("availData") int availData);

    int deleteById(String id, @Param("operator") String operator);



}