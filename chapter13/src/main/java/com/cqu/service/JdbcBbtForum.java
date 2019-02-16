package com.cqu.service;

import com.cqu.dao.ForumDao;
import com.cqu.domain.Forum;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/16 16:15
 * @description :  add description here
 */
public class JdbcBbtForum implements BbtForum {

    private ForumDao forumDao;

    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    public void addForum(Forum forum) {
        forumDao.addForum(forum);
    }
}
