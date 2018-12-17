package liyuanshuo.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author : liyuanshuo
 * @Date : 2018/12/11 21:01
 * @Description : 领域对象一般要实现序列化Serializable接口，以便可以序列化
 * @Version 1.0
 */
public class LoginLog implements Serializable {

    private Integer loginLogId;
    private Integer userId;
    private String ip;
    private Date loginDate;

    public Integer getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(Integer loginLogId) {
        this.loginLogId = loginLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
