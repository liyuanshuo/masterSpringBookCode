package com.cqu.service;

import com.cqu.domain.Post;
import com.cqu.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 19:52
 * @description :  add description here
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Rollback
@Transactional
public class TestBbtForumAnno extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    public BbtForum bbtForum;

    @Test
    public void testBbtForum(){
        System.out.println("begin........");
        Topic topic = new Topic();
        topic.setTopicTitle("Title -pfb");
        Post post = new Post();
        post.setPostText("post content -pfb");
        topic.setPost(post);
        bbtForum.addTopic(topic);
//    	((BbtForumImpl)bbtForum).setForumDao(null);
        System.out.println("end........");
    }
}
