package com.cqu.service;

import com.cqu.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 20:27
 * @description :  add description here
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Rollback
@Transactional
public class TestForumService extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    public ForumService1 forumService1;
    @Test
    public  void testForumService() throws Throwable{
        Forum forum = new Forum();
        forum.setForumDesc("desc");
        forum.setForumName("name");
        forumService1.addForum(forum);
//		ForumService forumService = ctx.getBean(ForumService.class);
//		System.out.println("begin...........");
//		forumService.addTopic();
//		System.out.println("end!!!!!!!!!!!!!");
    }
}
