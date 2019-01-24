package com.cqu.advisor;

import com.cqu.introduce.ForumService;
import com.cqu.introduce.Monitorable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 14:11
 * @description :  add description here
 */
public class IntroduceAdvisorTest {

    @Test
    public void testIntroduce(){
        String configPath = "com/cqu/advisor/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = context.getBean("forumService", ForumService.class);
        forumService.removeForum(10);
        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);
        forumService.removeForum(10);
    }
}
