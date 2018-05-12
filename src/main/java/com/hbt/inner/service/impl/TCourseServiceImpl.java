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

import com.hbt.inner.entity.TCourse;
import com.hbt.inner.service.TCourse;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
@Service("tCourseService")
public class TCourseServiceImpl implements TCourseService {

    private static Logger logger = LoggerFactory.getLogger(TCourseServiceImpl.class);

    @Resource
    private TCourseDao tCourseDao;

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
            TCourse tCourse = new TCourse();
            tCourse.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            tCourse.setName(name);
            tCourse.setUsername(username);
            tCourse.setTime(time);
            tCourse.setPicture(picture);
            tCourse.setBrief(brief);
            tCourse.setStudyCount(studyCount);
            tCourse.setScore(score);
            tCourse.setScoreCount(scoreCount);
            tCourse.setCreateTime(createTime);
            tCourse.setCreateUser(createUser);
            tCourse.setUpdateTime(updateTime);
            tCourse.setUpdateUser(updateUser);
            tCourse.setSysDelelte(sysDelelte);
            tCourseDao.save(tCourse);
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
            List<TCourse> tCourseList = CommonUtils.getListByJson(tCourseJson, TCourse.class);

            if (CommonUtils.isEmpty(tCourseList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            tCourseDao.saveBatch(tCourseList);
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
    @Stat
    public ListResult<TCourse> getTCourseById (String id, int availData){
        ListResult<TCourse> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<TCourse> tCourseList = tCourseDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(tCourseList)){
                result.setDataList(tCourseList);
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
    @Stat
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
    @Stat
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
        TCourse tCourse = new TCourse();
        tCourse.setId(id);
        tCourse.setName(name);
        tCourse.setUsername(username);
        tCourse.setTime(time);
        tCourse.setPicture(picture);
        tCourse.setBrief(brief);
        tCourse.setStudyCount(studyCount);
        tCourse.setScore(score);
        tCourse.setScoreCount(scoreCount);
        tCourse.setCreateTime(createTime);
        tCourse.setCreateUser(createUser);
        tCourse.setUpdateTime(updateTime);
        tCourse.setUpdateUser(updateUser);
        tCourse.setSysDelelte(sysDelelte);
        tCourse.setUpdateUser(operator);
        tCourseDao.update(tCourse);
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