package com.liyuanshuo.impt;

import com.liyuanshuo.fb.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 15:50
 * @description :  add description here
 */
public class Test {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/liyuanshuo/impt/beans2.xml");
        Car car = context.getBean("car1", Car.class);
        System.out.println(car.getMaxSpeed());
    }
}
