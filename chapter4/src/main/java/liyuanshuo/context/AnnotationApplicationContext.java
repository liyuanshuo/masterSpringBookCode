package liyuanshuo.context;

import liyuanshuo.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author : liyuanshuo
 * Date : 2018/12/18 0:35
 * Description :  add description here
 * Version 1.0
 * @author liyuanshuo
 */
public class AnnotationApplicationContext {
    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Beans.class);
        Car car = applicationContext.getBean("car", Car.class);
    }
}
