package com.hbt.inner.service.impl;

import com.hbt.inner.common.DataResult;
import com.hbt.inner.common.ListResult;
import com.hbt.inner.dao.UserDao;
import com.hbt.inner.param.userParam;
import com.hbt.inner.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hbt.inner.entity.User;


/**
* 描述：
* @author Json
* @date 2018-05-11
*/
@Service("userService")
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    /**
    * 注册
    */
    // @Transactional(rollbackFor = Exception.class)
    public DataResult<String> saveUser(userParam param){
        DataResult<String> result = new DataResult();
        if(param.getUsername()==null){
            result.setCode("1");
            result.setMessage("用户名不能为空");
            return result;
        }else if(param.getPassword()==null){
            result.setCode("1");
            result.setMessage("密码不能为空");
        }else if(userDao.getCountByUsername(param.getUsername())>0){
            result.setCode("1");
            result.setMessage("用户名已存在");
        }
        try{
            User user=User.builder().birthday(param.getBirthday()).gender(param.getGender()).header(param.getHeader()).mobile(param.getMobile())
                    .password(param.getPassword()).qq(param.getQq()).realname(param.getRealname()).username(param.getUsername()).title(param.getTitle())
                    .type(null).wechatId(param.getWechatId()).build();
            userDao.save(user);
        } catch (Exception e){
            logger.error("saveUser error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("注册失败");
        }
        return result;
    }

    /**
    * 批量保存

    @Override
    @Transactional(rollbackFor = Exception.class)
    DataResult<Boolean> saveUserBatch (String userJson, String operator){
        if(CommonUtils.isEmpty(userJson)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            List<User> userList = CommonUtils.getListByJson(userJson, User.class);

            if (CommonUtils.isEmpty(userList)) {
                result.setCode("1");
                result.setMessage("1");
                return result;
            }

            // TODO : 前置代码
            userDao.saveBatch(userList);
            result.setData(True);

            // TODO : 后置代码
        } catch (Exception e){
            logger.error("saveUserBatch error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }
     */

    /**
    * 登陆
    */
    public DataResult<User> login(String username,String password){
        DataResult<User> result = new DataResult();
        User user=userDao.getByUsername(username);
        if(username==null){
            result.setCode("1");
            result.setMessage("用户名不能为空");
            return result;
        }else if(password==null){
            result.setCode("1");
            result.setMessage("密码不能为空");
            result.setData(null);
            return result;
        }else if(user==null){
            result.setCode("1");
            result.setMessage("用户不存在");
            return result;
        } else if(!user.getUsername().equals(username)||!user.getPassword().equals(password)){
            result.setCode("1");
            result.setMessage("用户名或密码错误");
            return result;
        }else {
            result.setCode("0");
            result.setMessage("登陆成功");
            result.setData(user);
            return result;
        }
    }
    @Override
    public ListResult<User> getUserById (String username, int availData){
        ListResult<User> result = new ListResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
            List<User> userList = userDao.getById(id, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(userList)){
                result.setDataList(userList);
            }
        } catch (Exception e){
            logger.error("saveUserById error:{}", e.getMessage());
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
    public DataResult<Integer> deleteUserById(String id, String operator){
        DataResult<Integer> result = new DataResult();
        if(CommonUtils.isEmpty(id)){
            result.setCode("1");
            result.setCode("1");
            return result;
        }
        try{
            // TODO : 前置代码
        int count = userDao.deleteById(id, operator);
            // TODO : 后置代码
            result.setData(count);
        } catch (Exception e){
            logger.error("deleteUserById error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }



    /**
    * 更新对象
    */
//  @Transactional(rollbackFor = Exception.class)
    public DataResult<Boolean> updateUser(userParam param){
        DataResult<Boolean> result = new DataResult();
        try{
            User before=userDao.getById(param.getId());
            if(before==null){
                 result.setCode("1");
                 result.setMessage("待更新用户不存在");
                 return result;
            }
            User after=User.builder().id(param.getId()).birthday(param.getBirthday()).gender(param.getGender()).header(param.getHeader())
                    .mobile(param.getMobile()).password(param.getPassword()).qq(param.getQq()).realname(param.getRealname()).title(param.getTitle())
                    .wechatId(param.getWechatId()).build();
            userDao.update(after);
            result.setCode("0");
            result.setMessage("更新成功");
        } catch (Exception e){
            logger.error("updateUser error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    /**
    * 根据username查询记录
    *
    * @param username 真实姓名
	
    */
    @Override
    public ListResult<User> getUserByUsername (String username, int availData){
        ListResult<User> result = new ListResult();
        //TODO:数据校验
        //if(){
        //    result.setCode("1");
        //    result.setCode("1");
        //    return result;
        //}
        try{
            // TODO : 前置代码
            List<User> userList = userDao.getByUsername(username, availData);
            // TODO : 后置代码
            if(CommonUtils.isNotEmpty(userList)){
                result.setDataList(userList);
            }
        } catch (Exception e){
            logger.error("getUserByUsername error:{}", e.getMessage());
            result.setCode("1");
            result.setMessage("1");
        }
        return result;
    }

}