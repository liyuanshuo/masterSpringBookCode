package com.liyuanshuo.fb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 14:03
 * @description :  add description here
 */
@ContextConfiguration("classpath*:com/liyuanshuo/fb/beans.xml")
public class FactoryBeanTest extends AbstractTestNGSpringContextTests {

    @Autowired
    public ApplicationContext factory = null;

    @Test
    public void testCarFactoryBean(){
        Car car1 = factory.getBean("car1", Car.class);
        Car car2 = factory.getBean("car2", Car.class);
        assertNotNull(car1);
        assertNotNull(car2);
        assertNotSame(car1, car2);
        System.out.println("car1 : " + car1);
        System.out.println("car2 : " + car2);
    }

    @Test
    public void testCollFactoryBean(){
        List list = factory.getBean("favoriteList", List.class);
        Set set = factory.getBean("favoriteSet", Set.class);
        Map map = factory.getBean("emails", Map.class);
        Properties properties = factory.getBean("emailProps", Properties.class);
        assertEquals(set.size(), 3);
        assertEquals(list.size(), 3);
        assertEquals(map.size(), 2);
        assertEquals(properties.size(), 2);
    }

    @Test
    public void testFieldFactoryBean(){
        Car car2 = factory.getBean("car2", Car.class);
        assertNotNull(car2);
        System.out.println("car2 : : " + car2);
    }

    @Test
    public void testPropPathFactoryBean(){
        Car car5 = factory.getBean("car5", Car.class);
        Car car6 = factory.getBean("car6", Car.class);
        assertNotNull(car5);
        assertNotNull(car6);
        System.out.println("car5 : " + car5);
        System.out.println("car6 : " + car6);
    }

}
