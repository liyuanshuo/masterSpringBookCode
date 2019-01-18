package com.liyuanshuo.ditype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/18 20:02
 * @description :  add description here
 */
public class DiTypeTest {

    private ApplicationContext factory = null;
    private static String[] CONFIG_FILES = {"com/liyuanshuo/ditype/beans.xml"};

    @BeforeMethod
    public void setUp(){
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testCar(){
        Car car = factory.getBean("car", Car.class);
        assertNotNull(car);
        System.out.println("car : " + car);
    }

    @Test
    public void testCar1(){
        Car car1 = factory.getBean("car1", Car.class);
        assertNotNull(car1);
        System.out.println("car1 : " + car1);
    }

    @Test
    public void testCar2(){
        Car car2 = factory.getBean("car2", Car.class);
        assertNotNull(car2);
        System.out.println("car2 : "+ car2);
    }

    @Test
    public void testCar3(){
        Car car3 = factory.getBean("car3", Car.class);
        assertNotNull(car3);
        System.out.println("car3 : " + car3);
    }

    @Test
    public void testCar4(){
        Car car4 = factory.getBean("car4", Car.class);
        assertNotNull(car4);
        System.out.println("car4 : " + car4);
    }

    @Test
    public void testCar5(){
        Car car5 = factory.getBean("car5", Car.class);
        assertNotNull(car5);
        System.out.println("car5 : "+ car5);
    }

    @Test
    public void testCar6(){
        Car car6  = factory.getBean("car6", Car.class);
        assertNotNull(car6);
        System.out.println("car6 : " + car6);
    }

    @Test
    public void testBoss(){
        Boss boss = factory.getBean("boss", Boss.class);
        assertNotNull(boss);
        System.out.println("Boss : " + boss);
    }

}
