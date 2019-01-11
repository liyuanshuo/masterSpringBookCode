package com.liyuanshuo.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 20:02
 * @description :  add description here
 */
public class AnnoAutowireTest {
    public ApplicationContext factory = null;
    private static String[] CONFIG_FILES = {"beans.xml"};

    @BeforeMethod
    public void setUp(){
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testAutoByName(){
        Boss boss = factory.getBean("boss", Boss.class);
        assertNotNull(boss);
    }
}