package com.hbt.inner.dao;

import com.hbt.inner.entity.Ware;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
public interface WareDao {

    int save(@Param("entity") Ware entity);

    //int saveBatch(@Param("entities") List<Ware> entities);

    int update(@Param("entity") Ware entity);

    List<Ware> getById(@Param("id") String id, @Param("availData") int availData);

    int deleteById(String id, @Param("operator") String operator);



}