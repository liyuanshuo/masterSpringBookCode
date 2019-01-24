package com.cqu.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 19:27
 * @description :  add description here
 */
public class AdviceTest {

    @Test
    public void testAdvice(){
        String configPath = "com/cqu/advice/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = context.getBean("waiter", Waiter.class);
        assertNotNull(waiter);
        waiter.greetTo("John");
    }
}
