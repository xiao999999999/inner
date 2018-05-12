package com.hbt.inner.common;

import com.hbt.inner.entity.User;
import org.springframework.stereotype.Component;
    @Component
    public class HostHolder {
        private  static  ThreadLocal<User> users=new ThreadLocal<>();
        public  User getUser(){
            return users.get();
        }
        public  void setUsers(User user){
            users.set(user);
        }
        public  void clear(){
            users.remove();
        }
    }
