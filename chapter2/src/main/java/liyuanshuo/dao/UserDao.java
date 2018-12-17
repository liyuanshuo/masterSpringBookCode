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
 * @Date : 2018/12/11 21:04
 * @Description : 定义访问User的DAO，DAO具体包括内容依据具体的业务而定
 * @Version 1.0
 */
//通过spring注解定义一个DAO
@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    //这里把数据库查询语句写成字符串的形式，虽然方便了使用，但是并不灵活。以后在写的时候依照具体情况而定
    private final static String MATCH_COUNT_SQL = "select count(*) from t_user where user_name = ? and password = ?";
    private final static String UPDATE_LOGIN_INFO_SQL = "update t_user set last_visit= ?, last_ip= ?, credits= ?  where user_id= ?";
    private final static String QUERY_BY_USERNAME = "select user_id, user_name, credits from t_user where user_name=?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer getMatchCount(String userName, String password){
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    public User findUserByUserName(final String userName){
        final User user = new User();
        //这里使用RowCallbackHandler，匿名内部类实现的回调函数,将ResultSet转为User对象。
        jdbcTemplate.query(QUERY_BY_USERNAME, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[]{user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
    }
}
