package com.cqu.dao.mybatis;

import com.cqu.domain.Forum;

import java.util.List;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 20:20
 * @description :  add description here
 */
public interface ForumMybatisDao {
    void addForum(Forum forum);
    void updateForum(Forum forum);
    Forum getForum(int forumId);
    long getForumNum();
    List<Forum> findForumByName(String forumName);
}
