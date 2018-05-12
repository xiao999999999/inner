package com.hbt.inner.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
/**
   *param:
    create_time,
    create_user,
    update_time,
    update_user,
    sys_deleted
*/
@Getter
@Setter
@Builder
public abstract class BaseEntity {
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;


}
