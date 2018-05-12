package com.hbt.inner.controller;

import com.hbt.inner.common.DataResult;
import com.hbt.inner.entity.User;
import com.hbt.inner.param.userParam;
import com.hbt.inner.service.UploadService;
import com.hbt.inner.service.UserService;
import com.hbt.inner.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;


@Controller
@RequestMapping("/user")
public class UserController {
    private static  final Logger logger=LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UploadService uploadService;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(userParam param){
        DataResult result=userService.saveUser(param);
        return "redirect:/index";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request){
        DataResult result=userService.login(username,password);
        User user=(User)result.getData();
        if(user!=null) {
            request.getSession().setAttribute("user", user);
        }
        return CommonUtils.getJSONString(result.getCode(),result.getMessage());
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(userParam param){
        DataResult result=userService.updateUser(param);
        return CommonUtils.getJSONString(result.getCode(),result.getMessage());
    }
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file){
        DataResult result=uploadService.upload(file);
        String fileUrl=(String)result.getData();
        if(CommonUtils.isEmpty(fileUrl)){
            return CommonUtils.getJSONString("1","上传失败");
        }
        return CommonUtils.getJSONString("0",fileUrl);
    }
    @RequestMapping(value = "/image",method = RequestMethod.GET)
    @ResponseBody
    public void image(@RequestParam("name") String name, HttpServletResponse resp) {
        try {
            StreamUtils.copy(new FileInputStream(new File(CommonUtils.IMAGE_PATH + name)), resp.getOutputStream());
        }catch (Exception e){
            logger.error("展示图片失败"+e.getMessage());
        }

    }

}
