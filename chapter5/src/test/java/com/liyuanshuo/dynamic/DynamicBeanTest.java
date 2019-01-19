package com.liyuanshuo.dynamic;

import com.liyuanshuo.auto.Office;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/18 21:27
 * @description :  add description here
 */
public class DynamicBeanTest {
    private ApplicationContext factory = null;

    private static String[] CONFIG_FILES = {"com/liyuanshuo/dynamic/beans.xml"};

    @BeforeMethod
    public void setUp(){
        factory = new  ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void registerBean(){
        try {
            Object userService1 = factory.getBean("userService1");
            Object userService2 = factory.getBean("userService2");
            assertNotNull(userService1);
            assertNotNull(userService2);
        }catch (NoSuchBeanDefinitionException exception){
            exception.printStackTrace();
        }



        Object userService1 = factory.getBean("userService1");
        Object userService2 = factory.getBean("userService2");
        assertNotNull(userService1);
        assertNotNull(userService2);
    }
}
