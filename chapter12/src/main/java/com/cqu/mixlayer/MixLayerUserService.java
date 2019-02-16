package com.cqu.mixlayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/14 21:04
 * @description :  add description here
 */
@Controller
public class MixLayerUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/lodon.do")
    @Transactional
    public String logon(String userName, String password){
        if(isRightUser(userName,password)){
            String sql = "UPDATE t_user u SET u.score = u.score + ? WHERE user_name =?";
            jdbcTemplate.update(sql,20,userName);
            return "success";
        }else{
            return "fail";
        }
    }
    private boolean isRightUser(String userName,String password){
        //do sth
        return true;
    }
}
