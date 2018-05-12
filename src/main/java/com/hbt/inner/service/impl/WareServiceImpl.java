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

import com.hbt.inner.entity.Ware;
import com.hbt.inner.service.Ware;

/**
* 描述：
* @author Json
* @date 2018-05-11
*/
@Service("wareService")
public class WareServiceImpl implements WareService {

    private static Logger logger = LoggerFactory.getLogger(WareServiceImpl.class);

    @Resource
    private WareDao wareDao;

    /**
    * 单个保存
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    DataResult<String> saveWare(
            String name,
            String courseId,
            String picture,
            String brief,
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
            Ware ware = new Ware();
            ware.setId(CoderGenerator.getDeviceCode(NewCodeUtil.nodeId()));
            ware.setName(name);
            ware.setCourseId(courseId);
            ware.setPicture(picture);
            ware.setBrief(brief);
            ware.setCreateTime(createTime);
            ware.setCreateUser(createUser);
            ware.setUpdateTime(updateTime);
            ware.setUpdateUser(updateUser);
            ware.setSysDelelte(sysDelelte);
            wareDao.save(ware);
            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveWare error:{}", e.getMessage());
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
    DataResult<Boolean> saveWareBatch (String wareJson, String operator){
        if(CommonUtils.isEmpty(wareJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<Ware> wareList = CommonUtils.getListByJson(wareJson, Ware.class);

            if (CommonUtils.isEmpty(wareList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            wareDao.saveBatch(wareList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveWareBatch error:{}", e.getMessage());
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
    public ListResult<Ware> getWareById (String id, int availData){
        ListResult<Ware> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<Ware> wareList = wareDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(wareList)){
                result.setDataList(wareList);
            }
        } catch (Exception e){
            logger.error("saveWareById error:{}", e.getMessage());
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
    public DataResult<Integer> deleteWareById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = wareDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteWareById error:{}", e.getMessage());
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
    DataResult<Boolean> updateWare (
                String id,
                String name,
                String courseId,
                String picture,
                String brief,
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
        Ware ware = new Ware();
        ware.setId(id);
        ware.setName(name);
        ware.setCourseId(courseId);
        ware.setPicture(picture);
        ware.setBrief(brief);
        ware.setCreateTime(createTime);
        ware.setCreateUser(createUser);
        ware.setUpdateTime(updateTime);
        ware.setUpdateUser(updateUser);
        ware.setSysDelelte(sysDelelte);
        ware.setUpdateUser(operator);
        wareDao.update(ware);
            // TODO : 后置代码
            result.setData(True);
        } catch (Exception e){
            logger.error("updateWare error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

}