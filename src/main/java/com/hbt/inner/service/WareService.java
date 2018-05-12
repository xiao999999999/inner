package com.hbt.inner.service;

import com.hbt.inner.common.DataResult;
import com.hbt.inner.common.ListResult;
import com.hbt.inner.entity.Ware;

/**
 * 描述： 服务实现层接口
 *
 * @author Json
 * @date 2018-05-11
 */
public interface WareService {


    /**
     * 单个保存
     *
     * @param name       课件名称
     * @param courseId   归属课程id
     * @param picture    图片
     * @param brief      课件描述
     * @param sysDelelte 是否删除0(default)/1:否/是
     * @param operator   操作者编号
     */
    DataResult<String> saveWare(Ware param);

    /**
     * 批量保存
     * @param wareJson 对象集合 Json 字符串
     * @param operator 操作者编号
     */
//    DataResult<Boolean> saveWareBatch(String wareJson, String operator);

    /**
     * 根据id获取对象
     *
     * @param id
     */
    DataResult<Ware> getWareById(Integer id);

    /**
     * 根据id删除对象
     *
     * @param id
     */
    DataResult<Integer> deleteWareById(Integer id);


    /**
     * 更新对象
     *
     * @param id
     * @param name       课件名称
     * @param courseId   归属课程id
     * @param picture    图片
     * @param brief      课件描述
     * @param sysDelelte 是否删除0(default)/1:否/是
     * @param operator   操作者编号
     */
    DataResult<String> updateWare(Ware param);

}