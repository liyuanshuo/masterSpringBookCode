package com.cqu.dao;

import com.cqu.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 15:25
 * @description :  add description here
 */
@Repository
public class PostDao {

    private JdbcTemplate jdbcTemplate;

    public void addPost(final Post post){
        String sql = "INSERT INTO t_post(topic_id, post_text) VALUES(? , ?)";
        Object[] params = new Object[]{post.getTopicId(), post.getPostText()};
        jdbcTemplate.update(sql, params);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
