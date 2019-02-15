package com.cqu.dao;

import com.cqu.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 16:21
 * @description :  add description here
 */
@Repository
public class TopicDao {
    private JdbcTemplate jdbcTemplate;

    public void addTopic(final Topic topic){
        final String sql = "INSERT INTO t_topic(topic_title) VALUES(?)";
        Object[] params = new Object[]{topic.getTopicTitle()};
        jdbcTemplate.update(sql, params);


//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        getJdbcTemplate().update(new PreparedStatementCreator() {
//            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//                PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                preparedStatement.setString(1, topic.getTopicTitle());
//                return preparedStatement;
//            }
//        }, keyHolder);

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
