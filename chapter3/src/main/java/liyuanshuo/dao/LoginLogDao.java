package liyuanshuo.dao;

import liyuanshuo.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Author : liyuanshuo
 * Date : 2018/12/13 13:19
 * Description :  add description here
 * Version 1.0
 */
@Repository
public class LoginLogDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String INSERT_LOGIN_LOG_SQL = "insert into t_login_log(user_id, ip, login_date) values(?, ?, ?)";

    public void insertLoginLog(LoginLog loginLog){
        Object[] args = { loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, args);
    }
}
