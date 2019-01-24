package com.cqu.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.sql.SQLException;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 19:38
 * @description :  add description here
 */
public class ThrowAdviceTest {

    @Test
    public void testThrowAdvice(){
        String configPath = "com/cqu/advice/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = context.getBean("forumService", ForumService.class);



        try {
            forumService.removeForum(10);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }try {
            forumService.updateForum(new Forum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
