package com.hbt.inner.service;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.common.domain.PageResult;
import com.hbt.inner.entity.CourseSection;
import java.util.*;
import java.math.BigDecimal;

/**
* 描述： 服务实现层接口
* @author Json
* @date 2018-05-11
*/
public interface CourseSectionService {


    /**
    * 单个保存
    * @param userId 用户id
	* @param courseId 课程id
	* @param sectionId 章节id
	* @param status 状态：0-学习中；1-学习结束
	* @param rate 进度百分比
	* @param sysDelelte 是否删除0(default)/1:否/是
	
    * @param operator 操作者编号
    */
     DataResult<String>saveCourseSection(String userId, String courseId, String sectionId, String status, String rate, Boolean sysDelelte, String operator);

    /**
    * 批量保存
    * @param courseSectionJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    DataResult<Boolean> saveCourseSectionBatch(String courseSectionJson, String operator);

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<CourseSection> getCourseSectionById(String id, int availData);

    /**
    * 根据id删除对象
    * @param id 
    */
    DataResult<Integer> deleteCourseSectionById(String id, String operator);



    /**
    * 更新对象
    * @param id 
	* @param userId 用户id
	* @param courseId 课程id
	* @param sectionId 章节id
	* @param status 状态：0-学习中；1-学习结束
	* @param rate 进度百分比
	* @param sysDelelte 是否删除0(default)/1:否/是
	
    * @param operator 操作者编号
    */
    DataResult<Boolean> updateCourseSection(String id, String userId, String courseId, String sectionId, String status, String rate, Boolean sysDelelte, String operator);

}