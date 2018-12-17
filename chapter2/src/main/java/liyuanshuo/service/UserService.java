package liyuanshuo.service;

import liyuanshuo.dao.LoginLogDao;
import liyuanshuo.dao.UserDao;
import liyuanshuo.domain.LoginLog;
import liyuanshuo.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author : liyuanshuo
 * @Date : 2018/12/11 22:00
 * @Description :
 * @Version 1.0
 */
//将UserService标注为一个服务层的Bean。通过注解的方式
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
        Integer matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByName(String userName){
        return userDao.findUserByUserName(userName);
    }

    //事务注解，让该方法运行在事务环境中
    @Transactional
    public void loginSuccess(User user){
        user.setCredits(5+user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);

    }
}
