package com.cqu.nestcall;

import com.cqu.multithread.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/14 21:07
 * @description :  add description here
 */
@Service("scoreUserService")
public class ScoreService extends BaseService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScoreService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addScore(String userName, int toAdd){
        String sql = "UPDATE t_user u SET u.score = u.score + ? WHERE user_name =?";
        jdbcTemplate.update(sql, toAdd, userName);
    }
}
