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

import com.hbt.inner.entity.Section;
import com.hbt.inner.service.Section;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
@Service("sectionService")
public class SectionServiceImpl implements SectionService {

    private static Logger logger = LoggerFactory.getLogger(SectionServiceImpl.class);

    @Resource
    private SectionDao sectionDao;

    /**
    * 单个保存
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    DataResult<String> saveSection(
            String courseId,
            String parentId,
            String name,
            String sort,
            String time,
            String videoUrl,
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
            Section section = new Section();
            section.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            section.setCourseId(courseId);
            section.setParentId(parentId);
            section.setName(name);
            section.setSort(sort);
            section.setTime(time);
            section.setVideoUrl(videoUrl);
            section.setCreateTime(createTime);
            section.setCreateUser(createUser);
            section.setUpdateTime(updateTime);
            section.setUpdateUser(updateUser);
            section.setSysDelelte(sysDelelte);
            sectionDao.save(section);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveSection error:{}", e.getMessage());
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
    DataResult<Boolean> saveSectionBatch (String sectionJson, String operator){
        if(CommonUtils.isEmpty(sectionJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Section> sectionList = CommonUtils.getListByJson(sectionJson, Section.class);

            if (CommonUtils.isEmpty(sectionList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            sectionDao.saveBatch(sectionList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveSectionBatch error:{}", e.getMessage());
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
    public ListResult<Section> getSectionById (String id, int availData){
        ListResult<Section> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<Section> sectionList = sectionDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(sectionList)){
                result.setDataList(sectionList);
            }
        } catch (Exception e){
            logger.error("saveSectionById error:{}", e.getMessage());
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
    public DataResult<Integer> deleteSectionById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = sectionDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteSectionById error:{}", e.getMessage());
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
    DataResult<Boolean> updateSection (
                String id,
                String courseId,
                String parentId,
                String name,
                String sort,
                String time,
                String videoUrl,
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
        Section section = new Section();
        section.setId(id);
        section.setCourseId(courseId);
        section.setParentId(parentId);
        section.setName(name);
        section.setSort(sort);
        section.setTime(time);
        section.setVideoUrl(videoUrl);
        section.setCreateTime(createTime);
        section.setCreateUser(createUser);
        section.setUpdateTime(updateTime);
        section.setUpdateUser(updateUser);
        section.setSysDelelte(sysDelelte);
        section.setUpdateUser(operator);
        sectionDao.update(section);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateSection error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

}