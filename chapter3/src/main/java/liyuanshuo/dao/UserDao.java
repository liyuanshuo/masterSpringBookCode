package liyuanshuo.dao;

import liyuanshuo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author : liyuanshuo
 * @Date : 2018/12/13 12:54
 * @Description :  add description here
 * @Version 1.0
 */
/** 这里也是通过注解来定义一个spring的DAO **/
@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**这里把数据库查询语句写成字符串的形式，虽然方便了使用，但是并不灵活。以后在写的时候依照具体情况而定**/
    private final static String MATCH_COUNT_SQL= "select count(*) from t_user where user_name = ? and password = ?";
    private final static String UPDATE_LOGIN_INFO_SQL = "update t_user set last_visit = ?, last_ip=?, credits=? where user_id = ?";
    private final static String QUERY_BY_USERNAME = "select user_id, user_name, credits from t_user where user_name = ?";

    public Integer getMacthCount(String userName, String password){
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    public User findUserByUserName(final String userName){
        final User user = new User();
        jdbcTemplate.query(QUERY_BY_USERNAME, new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId());
    }
}
