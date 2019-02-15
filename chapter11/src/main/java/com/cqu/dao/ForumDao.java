package com.cqu.dao;

import com.cqu.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 16:51
 * @description :  add description here
 */
@Repository
public class ForumDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addForum(final Forum forum){
        final String sql = "INSERT INTO t_forum(forum_name, forum_desc) VALUES(?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, forum.getForumName());
                preparedStatement.setString(2, forum.getForumDesc());
                return preparedStatement;
            }
        }, keyHolder);
        forum.setForumId(keyHolder.getKey().intValue());
    }

    public Forum getForum(final int forumId){
        String sql = "SELECT forum_name, forum_desc, FORM t_forum WHERE forum_id = ?";
        final Forum forum = new Forum();
        jdbcTemplate.query(sql, new Object[]{forumId}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                forum.setForumId(forumId);
                forum.setForumName(resultSet.getString("forum_name"));
                forum.setForumDesc(resultSet.getString("forum_desc"));
            }
        });
        return forum;
    }

    public int getForumNum(){
        String sql  = "SELECT forum_id FROM t_forum";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public void updateForum(final Forum forum){
        final String sql = "UPDATE t_forum SET forum_name = ?, forum_desc = ?, WHERE forum_id = ?";
        Object[] params = new Object[]{forum.getForumName(), forum.getForumDesc(), forum.getForumId()};
        jdbcTemplate.update(sql, params);
    }

}
