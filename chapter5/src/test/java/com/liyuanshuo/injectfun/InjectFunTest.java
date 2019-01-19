package com.liyuanshuo.injectfun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 16:22
 * @description :  add description here
 */
public class InjectFunTest {
    private ApplicationContext factory = null;
    private static String[] CONFIG_FILES = {"com/liyuanshuo/injectfun/beans.xml"};

    @BeforeMethod
    public void setUp(){
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testLookUp(){
        MagicBoss magicBoss = factory.getBean("magicBoss", MagicBoss.class);
        assertNotNull(magicBoss);
        assertNotSame(magicBoss.getCar(), magicBoss.getCar());
    }

    @Test
    public void testReplace(){
        MagicBoss magicBoss = factory.getBean("boss1", MagicBoss.class);
        assertNotNull(magicBoss);
        assertEquals(magicBoss.getCar().getBrand(), "Boss2CarBrand");
    }

}
