package com.hbt.inner.service;


import com.hbt.inner.common.DataResult;
import com.hbt.inner.common.ListResult;
import com.hbt.inner.entity.User;
import com.hbt.inner.param.userParam;

import java.util.*;


/**
* 描述： 服务实现层接口
* @author Json
* @date 2018-05-11
*/
public interface UserService {


    /**
    * 单个保存
    * @param realname 登录用户名
	* @param username 真实姓名
	* @param password 密码
	* @param type 用户类型0(default)/1:普通用户/管理员
	* @param gender 性别
	* @param header 头像
	* @param mobile 手机号码
	* @param birthday 
	* @param title 头衔
	* @param wechatId 微信号
	* @param qq qq号
	* @param loginTime 最后一次登录时间
	* @param ip 最后一次登录IP
	* @param sysDelelte 是否删除0(default)/1:否/是
	
    * @param operator 操作者编号
    */
     DataResult<String> saveUser(userParam param);

    /**
    * 批量保存
    * @param userJson 对象集合 Json 字符串
    * @param operator 操作者编号

    DataResult<Boolean> saveUserBatch(String userJson, String operator);
	 */

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<User> getUserById(int id);

    /**
    * 根据id删除对象
    * @param id 
    */
    DataResult<Integer> deleteUserById(int id);



    /**
    * 更新对象
    * @param id 
	* @param realname 登录用户名
	* @param username 真实姓名
	* @param password 密码
	* @param type 用户类型0(default)/1:普通用户/管理员
	* @param gender 性别
	* @param header 头像
	* @param mobile 手机号码
	* @param birthday 
	* @param title 头衔
	* @param wechatId 微信号
	* @param qq qq号
	* @param loginTime 最后一次登录时间
	* @param ip 最后一次登录IP
	* @param sysDelelte 是否删除0(default)/1:否/是
	
    * @param operator 操作者编号
    */
    DataResult<Boolean> updateUser(userParam param);

    /**
    * 根据username查询记录
    *
        * @param username 真实姓名
	
    */
    ListResult<User> getUserByUsername(String username, int availData);
	DataResult<User> login(String username,String password);

}