package com.hbt.inner.service;

import com.hbt.inner.common.DataResult;
import com.hbt.inner.common.ListResult;
import com.hbt.inner.entity.Section;
/**
* 描述： 服务实现层接口
* @author Json
* @date 2018-05-11
*/
public interface SectionService {


    /**
    * 单个保存
    * @param courseId 归属课程id
	* @param parentId 父章节id，（只有2级）
	* @param name 章节名称
	* @param sort 排序
	* @param time 时长
	* @param videoUrl 课程地址
	* @param sysDelelte 是否删除0(default)/1:否/是
	
    * @param operator 操作者编号
    */
     DataResult<String> saveSection(String courseId, String parentId, String name, String sort, String time, String videoUrl, Boolean sysDelelte, String operator);

    /**
    * 批量保存
    * @param sectionJson 对象集合 Json 字符串
    * @param operator 操作者编号
    */
    DataResult<Boolean> saveSectionBatch(String sectionJson, String operator);

    /**
    * 根据id获取对象
    * @param id 
    */
    ListResult<Section> getSectionById(String id, int availData);

    /**
    * 根据id删除对象
    * @param id 
    */
    DataResult<Integer> deleteSectionById(String id, String operator);



    /**
    * 更新对象
    * @param id 
	* @param courseId 归属课程id
	* @param parentId 父章节id，（只有2级）
	* @param name 章节名称
	* @param sort 排序
	* @param time 时长
	* @param videoUrl 课程地址
	* @param sysDelelte 是否删除0(default)/1:否/是
	
    * @param operator 操作者编号
    */
    DataResult<Boolean> updateSection(String id, String courseId, String parentId, String name, String sort, String time, String videoUrl, Boolean sysDelelte, String operator);

}