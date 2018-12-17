package liyuanshuo.beanfactory;

import liyuanshuo.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Author : liyuanshuo
 * Date : 2018/12/17 22:22
 * Description :  add description here
 * Version 1.0
 * @author liyuanshuo
 */
public class BeanLifeCycle {

    private static void LifeCycleInBeanFactory(){
        /* 下面两句装载配置文件并启动容器**/
        String xmlPath = "beanfactory.xml";
        Resource resource = new ClassPathResource(xmlPath);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);

        /* 向容器中注册MyBeanPostProcessor后处理器**/
        beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());

        /*向容器中注册MyInstantiationAwareBeanPostProcessor后处理器**/
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        /*第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用。**/
        Car car1 = (Car) beanFactory.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        /*第二次从容器中获取car，直接从缓存池中获取**/
        Car car2 = beanFactory.getBean("car", Car.class);

        /*查看car1和car2是否指向同一引用**/
        System.out.println("car1 == car2 : " + (car1==car2));

        /*关闭容器**/
        beanFactory.destroySingletons();
    }


    public static void main(String[] args){
        LifeCycleInBeanFactory();
    }
}
