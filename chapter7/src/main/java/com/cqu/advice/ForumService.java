package com.cqu.advice;

import java.sql.SQLException;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 16:47
 * @description :  add description here
 */
public class ForumService {

    void removeForum(Integer forumId) throws RuntimeException {
        // to do sth ......
        throw new RuntimeException("Run Time Error......");
    }

    void updateForum(Forum forum) throws SQLException {
        //to do sth .......
        throw new SQLException("data update exception ......");
    }
}
