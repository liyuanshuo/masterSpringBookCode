package com.liyuanshuo.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 16:57
 * @description :  add description here
 */
public class BeanRetrieveTest {
    private ApplicationContext factory = null;
    private static String[] CONFIG_FILES = {"com/liyuanshuo/simple/beans.xml"};

    @BeforeMethod
    public void setUp(){
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testBeanRetrieve(){
        Car car = factory.getBean("#car", Car.class);
        assertNotNull(car);
    }
}
