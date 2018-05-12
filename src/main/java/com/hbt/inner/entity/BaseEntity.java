package com.hbt.inner.entity;

import java.util.Date;
/**
   *param:
    create_time,
    create_user,
    update_time,
    update_user,
    sys_deleted
*/
public abstract class BaseEntity {
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Date getUpdateTime(Date date) {
        return updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

}
