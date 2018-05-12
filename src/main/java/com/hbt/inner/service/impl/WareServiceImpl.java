package com.hbt.inner.service.impl;

import com.hbt.inner.common.DataResult;
import com.hbt.inner.common.ListResult;
import com.hbt.inner.dao.WareDao;
import com.hbt.inner.entity.User;
import com.hbt.inner.param.userParam;
import com.hbt.inner.service.WareService;
import com.hbt.inner.utils.CommonUtils;
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
    // @Transactional(rollbackFor = Exception.class)
    public DataResult<String> saveWare(Ware param){
        DataResult<String> result = new DataResult();
        if (CommonUtils.isEmpty(param.getName())) {
            result.setCode("1");
            result.setMessage("参数为空");
        }
        try{
            Ware ware = Ware.builder().brief(param.getBrief()).courseId(param.getCourseId()).name(param.getName()).picture(param.getPicture()).build();
            wareDao.save(ware);
            result.setCode("0");
        } catch (Exception e){
            logger.error("saveUser error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("注册失败");
        }
        return result;
    }
    /**
     * 批量保存
     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    DataResult<Boolean> saveWareBatch (String wareJson, String operator){
//        if(CommonUtils.isEmpty(wareJson)){
//            result.setCode("1");
//            result.setCode("1");
//            return result;
//        }
//        try{
//            List<Ware> wareList = CommonUtils.getListByJson(wareJson, Ware.class);
//
//            if (CommonUtils.isEmpty(wareList)) {
//                result.setCode("1");
//                result.setMessage("1");
//                return result;
//            }
//
//            // TODO : 前置代码
//            wareDao.saveBatch(wareList);
//            result.setData(True);
//
//            // TODO : 后置代码
//        } catch (Exception e){
//            logger.error("saveWareBatch error:{}", e.getMessage());
//            result.setCode("1");
//            result.setMessage("1");
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        }
//        return result;
//    }

    /**
     * 根据id获取对象
     */
    @Override
    public DataResult<Ware> getWareById (Integer id){
        DataResult<Ware> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("id is empty");
            return result;
        }
        try{
            Ware ware = wareDao.getById(id);
            result.setCode("0");
        } catch (Exception e){
            logger.error("getWareById error:{}", e.getMessage());
            result.setCode("0");
            result.setMessage("getWareById is error");
        }
        return result;
    }

    /**
     * 根据id删除对象
     */
    @Override
//    @Transactional(rollbackFor = Exception.class)
    public DataResult<Integer> deleteWareById(Integer id){
        DataResult<Integer> result = new DataResult();
        if (CommonUtils.isEmpty(String.valueOf(id))) {
            result.setCode("1");
            result.setCode("id is empty");
            return result;
        }
        try{
            int count = wareDao.deleteById(id);
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteWareById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("deleteWareById is error");
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }



    /**
     * 更新对象
     */
    @Override
//    @Transactional(rollbackFor = Exception.class)
    DataResult<Boolean> updateWare (Ware param
    ){
        DataResult<Boolean> result = new DataResult();
        if(false){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            Ware ware = wareDao.getById(param.getId());

                    Ware ware = Ware.builder().brief(param.getBrief()).courseId(param.getCourseId()).name(param.getName()).picture(param.getPicture()).build();

            wareDao.update(ware);
            result.setData(True);
        } catch (Exception e){
            logger.error("updateWare error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

}