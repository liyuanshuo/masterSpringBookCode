package liyuanshuo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Author : liyuanshuo
 * Date : 2018/12/17 22:07
 * Description :  add description here
 * Version 1.0
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String brand;
    private String color;
    private Integer maxSpeed;
    private String name;
    private BeanFactory beanFactory;
    private String beanName;

    public Car(){
        System.out.println("调用Car()的构造函数");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println();
        System.out.println("调用setBrand()设置brand的属性");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", name='" + name + '\'' +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    /**BeanFactoryAware接口方法**/
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()。");
        this.beanFactory = beanFactory;
    }

    /**BeanNameAware接口方法**/
    public void setBeanName(String s) {
        System.out.println("调用BeanNameAware.setBeanName()。");
        this.beanName = s;
    }

    /**DisposableBean接口方法**/
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory()。");
    }

    /**InitializingBean接口方法**/
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()。");
    }

    public void myInit(){
        System.out.println("调用myInit()，将maxSpeed设置为240。");
        this.maxSpeed = 240;
    }

    public void myDestory(){
        System.out.println("调用myDestroy()。");
    }

    public void introduce(){
        System.out.println("introduce" + this.toString());
    }

}
