package com.liyuanshuo.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/18 17:29
 * @description :  add description here
 */
public class AutowireTest {

    private ApplicationContext factory = null;
    private static String[] CONFIG_FILES = {"com/liyuanshuo/auto/beans.xml"};

    @BeforeMethod
    public void setUp(){
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testAutoByName(){
        Boss  boss = factory.getBean("boss", Boss.class);
        assertNotNull(boss);
        System.out.println("boss" + boss.toString());
    }
}
