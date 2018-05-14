package com.hbt.inner.service;

import com.hbt.inner.common.DataResult;
import com.hbt.inner.common.ListResult;
import com.hbt.inner.entity.Course;

/**
* 描述： 服务实现层接口
* @author Json
* @date 2018-05-11
*/
public interface CourseService {


    /**
    * 单个保存
    * @param name 课程名称
	* @param username 归属人
	* @param time 时长
	* @param picture 图片
	* @param brief 课程描述
	* @param studyCount 学习人数
	* @param score 评分
	* @param scoreCount 评分人数
	* @param sysDelelte 是否删除0(default)/1:否/是
	
    * @param operator 操作者编号
    */
     DataResult<String> saveTCourse(String name, String username, String time, String picture, String brief, String studyCount, String score, String scoreCount, Boolean sysDelelte, String operator);

    /**
    * 批量保存
    * @param tCourseJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    DataResult<Boolean> saveTCourseBatch(String tCourseJson, String operator);

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<Course> getTCourseById(String id, int availData);

    /**
    * 根据id删除对象
    * @param id 
    */
    DataResult<Integer> deleteTCourseById(String id, String operator);



    /**
    * 更新对象
    * @param id 
	* @param name 课程名称
	* @param username 归属人
	* @param time 时长
	* @param picture 图片
	* @param brief 课程描述
	* @param studyCount 学习人数
	* @param score 评分
	* @param scoreCount 评分人数
	* @param sysDelelte 是否删除0(default)/1:否/是
	
    * @param operator 操作者编号
    */
    DataResult<Boolean> updateTCourse(String id, String name, String username, String time, String picture, String brief, String studyCount, String score, String scoreCount, Boolean sysDelelte, String operator);

}