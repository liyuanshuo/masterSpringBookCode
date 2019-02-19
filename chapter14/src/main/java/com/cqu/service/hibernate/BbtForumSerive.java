package com.cqu.service.hibernate;

import com.cqu.dao.hibernate.ForumHibernateDao;
import com.cqu.dao.hibernate.PostHibernateDao;
import com.cqu.dao.hibernate.TopicHibernateDao;
import com.cqu.domain.Forum;
import com.cqu.domain.Post;
import com.cqu.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 20:23
 * @description :  add description here
 */
@Transactional
@Service
public class BbtForumSerive {
    private ForumHibernateDao forumDao;

    private TopicHibernateDao topicDao;

    private PostHibernateDao postDao;

    public ForumHibernateDao getForumDao() {
        return forumDao;
    }

    @Autowired
    public void setForumDao(ForumHibernateDao forumDao) {
        this.forumDao = forumDao;
    }

    public TopicHibernateDao getTopicDao() {
        return topicDao;
    }

    @Autowired
    public void setTopicDao(TopicHibernateDao topicDao) {
        this.topicDao = topicDao;
    }

    public PostHibernateDao getPostDao() {
        return postDao;
    }

    @Autowired
    public void setPostDao(PostHibernateDao postDao) {
        this.postDao = postDao;
    }

    public void addForum(Forum forum) {
        forumDao.addForum(forum);
    }
    public void addTopic(Topic topic) {
        topicDao.addTopic(topic);
    }
    public void addPost(Post post) {
        postDao.addPost(post);
    }

    public Forum getForum(int forumId) {
        return forumDao.getForum(forumId);
    }
    public void updateForum(Forum forum) {
        forumDao.updateForum(forum);
    }
    public long getForumNum() {
        return forumDao.getForumNum();
    }
    public List findForumByName(String forumName) {
        return forumDao.findForumByName(forumName);
    }
    public Post getPost(int postId) {
        return postDao.getPost(postId);
    }
}
