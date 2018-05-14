package com.hbt.inner.service.impl;

import com.hbt.inner.dao.CourseDao;
import com.hbt.inner.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;
import com.ioe.stat.annotation.Stat;

import com.ioe.common.domain.DataResult;
import com.ioe.common.domain.ListResult;
import com.ioe.common.domain.PageResult;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hbt.inner.entity.Course;
import com.hbt.inner.service.TCourse;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
@Service("tCourseService")
public class CourseServiceImpl implements CourseService {

    private static Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Resource
    private CourseDao CourseDao;

    /**
    * 单个保存
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    DataResult<String> saveTCourse(
            String name,
            String username,
            String time,
            String picture,
            String brief,
            String studyCount,
            String score,
            String scoreCount,
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
            Course course = new Course();
            course.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            course.setName(name);
            course.setUsername(username);
            course.setTime(time);
            course.setPicture(picture);
            course.setBrief(brief);
            course.setStudyCount(studyCount);
            course.setScore(score);
            course.setScoreCount(scoreCount);
            course.setCreateTime(createTime);
            course.setCreateUser(createUser);
            course.setUpdateTime(updateTime);
            course.setUpdateUser(updateUser);
            course.setSysDelelte(sysDelelte);
            tCourseDao.save(course);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveTCourse error:{}", e.getMessage());
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
    DataResult<Boolean> saveTCourseBatch (String tCourseJson, String operator){
        if(CommonUtils.isEmpty(tCourseJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Course> courseList = CommonUtils.getListByJson(tCourseJson, Course.class);

            if (CommonUtils.isEmpty(courseList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            tCourseDao.saveBatch(courseList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveTCourseBatch error:{}", e.getMessage());
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

    public ListResult<Course> getTCourseById (String id, int availData){
        ListResult<Course> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<Course> courseList = tCourseDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(courseList)){
                result.setDataList(courseList);
            }
        } catch (Exception e){
            logger.error("saveTCourseById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

    /**
    * 根据id删除对象
    */
    @Override

    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteTCourseById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = tCourseDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteTCourseById error:{}", e.getMessage());
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

    @Transactional(rollbackFor = Exception.class)
    DataResult<Boolean> updateTCourse (
                String id,
                String name,
                String username,
                String time,
                String picture,
                String brief,
                String studyCount,
                String score,
                String scoreCount,
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
        Course course = new Course();
        course.setId(id);
        course.setName(name);
        course.setUsername(username);
        course.setTime(time);
        course.setPicture(picture);
        course.setBrief(brief);
        course.setStudyCount(studyCount);
        course.setScore(score);
        course.setScoreCount(scoreCount);
        course.setCreateTime(createTime);
        course.setCreateUser(createUser);
        course.setUpdateTime(updateTime);
        course.setUpdateUser(updateUser);
        course.setSysDelelte(sysDelelte);
        course.setUpdateUser(operator);
        tCourseDao.update(course);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateTCourse error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

}