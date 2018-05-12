package com.hbt.inner.param;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class userParam {
    private int id;
     /**
     *真实姓名
     */
    private String realname;

    /**
     *登录用户名
     */
    private String username;

    /**
     *密码
     */
    private String password;

    /**
     *用户类型0(default)/1:普通用户/管理员
     */
    private Boolean type;

    /**
     *性别
     */
    private Boolean gender;

    /**
     *头像
     */
    private String header;

    /**
     *手机号码
     */
    private String mobile;

    /**
     *
     */
    private Date birthday;

    /**
     *头衔
     */
    private String title;

    /**
     *微信号
     */
    private String wechatId;

    /**
     *qq号
     */
    private String qq;

}
