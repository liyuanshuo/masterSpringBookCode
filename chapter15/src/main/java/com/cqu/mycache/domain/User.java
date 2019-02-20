package com.cqu.mycache.domain;

import java.io.Serializable;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/20 16:32
 * @description :  add description here
 */
public class User implements Serializable {
    private String userId;
    private String userName;
    private int age;
    private String userCode;

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public User(String userId, String userName, int age) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", userCode='" + userCode + '\'' +
                '}';
    }
}
