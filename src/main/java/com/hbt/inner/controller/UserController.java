package com.hbt.inner.controller;

import com.hbt.inner.common.DataResult;
import com.hbt.inner.entity.User;
import com.hbt.inner.param.userParam;
import com.hbt.inner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public DataResult save(userParam param){
        DataResult result=userService.saveUser(param);

        return result;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public DataResult login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request){
        DataResult result=userService.login(username,password);
        User user=(User)result.getData();
        request.getSession().setAttribute("user",user);
        return result;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public DataResult update(userParam param){
        DataResult result=userService.login(username,password);
        User user=(User)result.getData();
        request.getSession().setAttribute("user",user);
        return result;
    }
}
