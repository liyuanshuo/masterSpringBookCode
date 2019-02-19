package com.cqu.domain.hibernata;

import com.cqu.dao.hibernate.ForumHibernateDao;
import com.cqu.dao.hibernate.PostHibernateDao;
import com.cqu.domain.Forum;
import com.cqu.domain.Post;
import com.cqu.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 20:43
 * @description :  add description here
 */
@ContextConfiguration(locations = { "classpath:applicationContext-hbt.xml" })
@Transactional
public class TestXmlHibernateDao extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private ForumHibernateDao forumDao;

    @Autowired
    private PostHibernateDao postDao;

    @Test
    public void testAddPost() throws Throwable{
        Topic topic = new Topic();
        topic.setTopicId(1);
        Post post = new Post();
        post.setPostId(10);
        post.setPostText("post text...");

        Resource resource = new ClassPathResource("temp.jpg");
        byte[] imgFile = FileCopyUtils.copyToByteArray(resource.getFile());
        post.setPostAttach(imgFile);
        post.setTopic(topic);
        postDao.addPost(post);

    }

    @Test
    public void testFindForumByName() {
        List<Forum> forums = forumDao.findForumByName("forum");
        Assert.assertTrue(forums.size() > 0);
    }
}
