package com.liyuanshuo.groovy;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 15:14
 * @description :  add description here
 */
public class LogonService {

    private UserDao userDao;
    private LogDao logDao;
    private MailService mailService;

    public LogonService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public LogDao getLogDao() {
        return logDao;
    }

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }
}
