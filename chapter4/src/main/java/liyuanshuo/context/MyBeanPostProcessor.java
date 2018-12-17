package liyuanshuo.context;

import liyuanshuo.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Author : liyuanshuo
 * Date : 2018/12/18 0:27
 * Description :  add description here
 * Version 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    private String beanName = "car";
    private Integer maxSpeed = 200;
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (this.beanName.equals(s)){
            Car car = (Car) o;
            if (car.getColor() == null){
                System.out.println("调用MyBeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黑色。");
                car.setColor("黑色");
            }
        }

        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (this.beanName.equals(s)){
            Car car = (Car) o;
            if (car.getMaxSpeed() >= this.maxSpeed){
                System.out.println("调用MyBeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200。");
                car.setMaxSpeed(this.maxSpeed);
            }
        }
        return o;
    }
}
