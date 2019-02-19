package com.cqu.service.mybatis;

import com.cqu.dao.mybatis.ForumMybatisDao;
import com.cqu.dao.mybatis.PostMybatisDao;
import com.cqu.dao.mybatis.TopicMybatisDao;
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
 * @date : 2019/2/19 20:25
 * @description :  add description here
 */
@Transactional
@Service
public class BbtForumSerive {
    private ForumMybatisDao forumDao;

    private TopicMybatisDao topicDao;

    private PostMybatisDao postDao;

    @Autowired
    public void setForumDao(ForumMybatisDao forumDao) {
        this.forumDao = forumDao;
    }

    @Autowired
    public void setTopicDao(TopicMybatisDao topicDao) {
        this.topicDao = topicDao;
    }

    @Autowired
    public void setPostDao(PostMybatisDao postDao) {
        this.postDao = postDao;
    }

    public ForumMybatisDao getForumDao() {
        return forumDao;
    }

    public TopicMybatisDao getTopicDao() {
        return topicDao;
    }

    public PostMybatisDao getPostDao() {
        return postDao;
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
    public List<Forum> findForumByName(String forumName) {
        return forumDao.findForumByName(forumName);
    }
    public Post getPost(int postId) {
        return postDao.getPost(postId);
    }
}
