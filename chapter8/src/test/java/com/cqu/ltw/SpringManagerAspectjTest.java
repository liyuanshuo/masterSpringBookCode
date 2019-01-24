package com.cqu.ltw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 16:28
 * @description :  add description here
 */
public class SpringManagerAspectjTest {
    @Test
    public void testMain() {
        String configPath = "com/cqu/ltw/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

//		Topic topic = new Topic();
//		topic.setTitle("测试主题");
//
//		Object obj = ctx.getBean("aspectj");
//		System.out.println("TopicAspectj:" + obj);
    }
}
