package com.cqu.mixdao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/14 20:46
 * @description :  add description here
 */

@Service("scoreService")
public class ScoreService extends BaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addScore(String userName, int toAdd){
        String sql = "UPDATE t_user u SET u.score = u.score + ? WHERE user_name =?";
        jdbcTemplate.update(sql, toAdd, userName);
        BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();
        System.out.println("[scoreUserService.addScore]激活连接数量：" + basicDataSource.getNumActive());
    }
}
