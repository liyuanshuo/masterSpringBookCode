package com.cqu.service;

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
 * @date : 2019/2/15 17:14
 * @description :  add description here
 */
@Service
@Transactional
public class BbtForum {

    private ForumDao forumDao;
    private TopicDao topicDao;
    private PostDao postDao;

    @Autowired
    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    public void addTopic(Topic topic){
        topicDao.addTopic(topic);
        postDao.addPost(topic.getPost());
    }

    @Transactional(readOnly = true)
    public Forum getForum(int forumId){
        return forumDao.getForum(forumId);
    }

    public void updateForum(Forum forum){
        forumDao.updateForum(forum);
    }

    public int getForumNum(){
        return forumDao.getForumNum();
    }
}
