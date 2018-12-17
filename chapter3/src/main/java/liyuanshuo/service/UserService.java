package liyuanshuo.service;

import liyuanshuo.dao.LoginLogDao;
import liyuanshuo.dao.UserDao;
import liyuanshuo.domain.LoginLog;
import liyuanshuo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Author : liyuanshuo
 * Date : 2018/12/13 13:26
 * Description :  add description here
 * Version 1.0
 */
@Service
public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUser(String userName, String password){
        Integer marachCount = userDao.getMacthCount(userName, password);
        return marachCount > 0;
    }

    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(User user){
        user.setCredits(5+user.getCredits());
        LoginLog loginLog;
        loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(new Date());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

}
