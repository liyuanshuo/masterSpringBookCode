package com.liyuanshuo.anno;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 19:44
 * @description :  add description here
 */
@Service
public class LogonService implements BeanNameAware {
    public void setBeanName(String s) {
        System.out.println("beanName: " + s);
    }

    @Lazy
    @Autowired(required = false)
    private LogDao logDao;

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveLog(){
        logDao.saveLog();
    }

    public LogDao getLogDao() {
        return logDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void initMethod1(){
        System.out.println("initMethod1");
    }

    public void initMethod2(){
        System.out.println("initMethod2");
    }
}
