package liyuanshuo.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * Author : liyuanshuo
 * Date : 2018/12/12 14:02
 * Description :  add description here
 * Version 1.0
 */
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String password;
    private Integer credits;
    private String lastIp;
    private Date lastVisit;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }
}
