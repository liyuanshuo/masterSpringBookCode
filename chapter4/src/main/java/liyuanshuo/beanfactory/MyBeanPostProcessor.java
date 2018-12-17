package liyuanshuo.beanfactory;

import liyuanshuo.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Author : liyuanshuo
 * Date : 2018/12/17 23:39
 * Description :  add description here
 * Version 1.0
 * @author liyuanshuo
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        String beanName = "car";
        Integer maxSpeed = 200;
        if (beanName.equals(s)){
            Car car = (Car) o;
            if (car.getMaxSpeed() >= maxSpeed){
                System.out.println("调用MyBeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200。");
                car.setMaxSpeed(200);
            }
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        String beanName = "car";
        if (beanName.equals(s)){
            Car car = (Car) o;
            if (car.getColor() == null){
                System.out.println("调用MyBeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黑色。");
                car.setColor("黑色");
            }
        }
        return o;
    }
}
