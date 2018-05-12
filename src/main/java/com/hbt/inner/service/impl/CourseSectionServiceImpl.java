package com.hbt.inner.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;
import com.ioe.stat.annotation.Stat;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.common.domain.PageResult;
import java.util.*;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;

import com.hbt.inner.entity.CourseSection;
import com.hbt.inner.service.CourseSection;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
@Service("courseSectionService")
public class CourseSectionServiceImpl implements CourseSectionService {

    private static Logger logger = LoggerFactory.getLogger(CourseSectionServiceImpl.class);

    @Resource
    private CourseSectionDao courseSectionDao;

    /**
    * 单个保存
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    DataResult<String> saveCourseSection(
            String userId,
            String courseId,
            String sectionId,
            String status,
            String rate,
            Boolean sysDelelte,
            String operator
    ){
        DataResult<String> result = new DataResult();
        if(false){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            CourseSection courseSection = new CourseSection();
            courseSection.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            courseSection.setUserId(userId);
            courseSection.setCourseId(courseId);
            courseSection.setSectionId(sectionId);
            courseSection.setStatus(status);
            courseSection.setRate(rate);
            courseSection.setCreateTime(createTime);
            courseSection.setCreateUser(createUser);
            courseSection.setUpdateTime(updateTime);
            courseSection.setUpdateUser(updateUser);
            courseSection.setSysDelelte(sysDelelte);
            courseSectionDao.save(courseSection);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveCourseSection error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 批量保存
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    DataResult<Boolean> saveCourseSectionBatch (String courseSectionJson, String operator){
        if(CommonUtils.isEmpty(courseSectionJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<CourseSection> courseSectionList = CommonUtils.getListByJson(courseSectionJson, CourseSection.class);

            if (CommonUtils.isEmpty(courseSectionList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            courseSectionDao.saveBatch(courseSectionList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveCourseSectionBatch error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 根据id获取对象
    */
    @Override
    @Stat
    public ListResult<CourseSection> getCourseSectionById (String id, int availData){
        ListResult<CourseSection> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<CourseSection> courseSectionList = courseSectionDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(courseSectionList)){
                result.setDataList(courseSectionList);
            }
        } catch (Exception e){
            logger.error("saveCourseSectionById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

    /**
    * 根据id删除对象
    */
    @Override
    @Stat
    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteCourseSectionById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = courseSectionDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteCourseSectionById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }



    /**
    * 更新对象
    */
    @Override
    @Stat
    @Transactional(rollbackFor = Exception.class)
    DataResult<Boolean> updateCourseSection (
                String id,
                String userId,
                String courseId,
                String sectionId,
                String status,
                String rate,
                Boolean sysDelelte,
                String operator
    ){
        DataResult<Boolean> result = new DataResult();
        if(false){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        CourseSection courseSection = new CourseSection();
        courseSection.setId(id);
        courseSection.setUserId(userId);
        courseSection.setCourseId(courseId);
        courseSection.setSectionId(sectionId);
        courseSection.setStatus(status);
        courseSection.setRate(rate);
        courseSection.setCreateTime(createTime);
        courseSection.setCreateUser(createUser);
        courseSection.setUpdateTime(updateTime);
        courseSection.setUpdateUser(updateUser);
        courseSection.setSysDelelte(sysDelelte);
        courseSection.setUpdateUser(operator);
        courseSectionDao.update(courseSection);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateCourseSection error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

}