package com.liyuanshuo.dynamic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/18 21:33
 * @description :  add description here
 */
public class CustomSchemaTest {
    private ApplicationContext factory = null;
    private static String[] CONFIG_FILES = {"com/liyuanshuo/dynamic/custom.xml"};

    @BeforeClass
    public void setUp(){
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void registerBean(){
        Object userService = factory.getBean("userService");
        assertNotNull(userService);
    }
}
