package com.hbt.inner.dao;

import com.hbt.inner.entity.User;

import org.apache.ibatis.annotations.Param;
import java.util.*;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
public interface UserDao {

    int save(@Param("entity") User entity);

    //int saveBatch(@Param("entities") List<User> entities);

    int update(@Param("entity") User entity);

    User getById(@Param("id") int id);

    int getCountByUsername(@Param("username") String username);

    int deleteById(int id);
    /**
    * index:t_auth_user ==> T_AUTH_USER_USERNAME_UNIQUE
    */
    User getByUsername(String username);

}