package com.cqu.service;

import com.cqu.domain.Post;
import com.cqu.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 20:15
 * @description :  add description here
 */
@ContextConfiguration(locations = {"classpath:applicationContext-aspectj.xml"})
@Rollback
@Transactional
public class TestBbtForumAspectj {
    @Autowired
    public BbtForum bbtForum;

    @Test
    public void testBbtForumAspectj() throws Throwable {
        Topic topic = new Topic();
        topic.setTopicTitle("Title -pfb");
        Post post = new Post();
        post.setPostText("post content -pfb");
        topic.setPost(post);
        System.out.println("begin........");
        System.out.println(topic);
        bbtForum.addTopic(topic);
        System.out.println("end........");
    }
}
