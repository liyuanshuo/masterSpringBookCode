package com.cqu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/14 14:33
 * @description :  add description here
 */

@Entity(name = "User")
@Table(name = "T_USER")
public class User implements Serializable {

    @Id
    @Column(name = "USER_NAME")
    private String userName;

    private String password;

    @Column(name = "LAST_LOGON_TIME")
    private String lastLogonTime = new Date(System.currentTimeMillis()).toString();

    private Integer score;

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

    public String getLastLogonTime() {
        return lastLogonTime;
    }

    public void setLastLogonTime(String lastLogonTime) {
        this.lastLogonTime = lastLogonTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastLogonTime=" + lastLogonTime +
                ", score=" + score +
                '}';
    }
}
