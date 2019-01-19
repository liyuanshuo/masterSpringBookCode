package com.liyuanshuo.dynamic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/18 20:58
 * @description :  add description here
 */
@Component
public class UserServiceFactoryBean implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //1. 将ConfigurableListableBeanFactory转化为DefaultListableBeanFactory
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableListableBeanFactory;
        //2. 通过BeanDefinitionBuilder创建Bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserService.class);
        //3. 设置属性userDao,此属性引用已经定义的bean:userDao
        beanDefinitionBuilder.addPropertyReference("userDao", "userDao");
        //4. 注册Bean定义
        beanFactory.registerBeanDefinition("userService1", beanDefinitionBuilder.getRawBeanDefinition());
        //5. 直接注册一个Bean实例
        beanFactory.registerSingleton("userService2", new UserService());
    }
}
