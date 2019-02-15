package com.cqu.service;

import com.cqu.ForumTransactional;
import com.cqu.TopicTransactional;
import com.cqu.dao.ForumDao;
import com.cqu.dao.PostDao;
import com.cqu.dao.TopicDao;
import com.cqu.domain.Forum;
import com.cqu.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 17:20
 * @description :  add description here
 */
@Service
public class MultiForumService {
    private ForumDao forumDao;
    private TopicDao topicDao;
    private PostDao postDao;

    public ForumDao getForumDao() {
        return forumDao;
    }

    @Autowired
    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    public TopicDao getTopicDao() {
        return topicDao;
    }

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    /** @Transactional("topic") */
    @TopicTransactional
    public void addTopic(Topic topic){
        System.out.println("topic tx ......");
    }

    /** @Transactional("forum") */
    @ForumTransactional
    public void updateForum(Forum forum){
        System.out.println("forum tx ........");
    }

}
