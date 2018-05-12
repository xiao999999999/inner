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

    Ware getById(@Param("id") Integer id);

    int deleteById(Integer id);

}