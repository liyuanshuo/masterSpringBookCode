package com.cqu.introduce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 21:52
 * @description :  add description here
 */
public class IntroduceTest {

    @Test
    public void testIntroduce(){
        String configPath = "com/cqu/introduce/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService)context.getBean("forumService");
        forumService.removeForum(10);
        forumService.removeTopic(1022);
        Monitorable moniterable = (Monitorable)forumService;
        moniterable.setMonitorActive(true);
        forumService.removeForum(10);
        forumService.removeTopic(1022);
    }
}
