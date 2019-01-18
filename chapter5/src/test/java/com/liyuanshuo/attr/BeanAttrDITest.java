package com.liyuanshuo.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/18 17:03
 * @description :  add description here
 */
public class BeanAttrDITest {
    public ApplicationContext factory = null;
    private static String[] CONFIG_FILES = {"com/liyuanshuo/attr/beans.xml"};

    @BeforeClass
    public void setUp(){
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testBeanRetrieveCar(){
        Car car = factory.getBean("car", Car.class);
        assertNotNull(car);

        System.out.println("***" + car + "***");
    }

    @Test
    public void testBeanRetrieveBoss(){
        Boss boss1 = factory.getBean("boss1", Boss.class);
        Boss boss2 = factory.getBean("boss2", Boss.class);
        assertSame(boss1.getCar(), boss2.getCar());

    }

    /**boss3没有再xml文件中定义，所以说这里测试不会通过**/
    @Test
    public void testBeanRetrieveBoss3(){
        Boss boss3 = factory.getBean("boss3",Boss.class);
        assertNotNull(boss3.getCar().getBrand());
    }

    @Test
    public void testBeanRetrieveBoss1(){
        Boss boss1 = factory.getBean("boss1", Boss.class);
        assertNotNull(boss1);
        System.out.println("boss1 : " + boss1);
    }

    @Test
    public void testBeanRetrieveChildBoss(){
        Boss childBoss = factory.getBean("childBoss", Boss.class);
        assertNotNull(childBoss);
        System.out.println("childBoss : " + childBoss);
    }

    @Test
    public void testCascadeAttr(){
        SportsCar sportsCar = factory.getBean("sportsCar", SportsCar.class);
        assertNotNull(sportsCar);
        System.out.println("sportsCar : " + sportsCar);
    }

}
