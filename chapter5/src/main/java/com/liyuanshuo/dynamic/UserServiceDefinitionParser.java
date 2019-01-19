package com.liyuanshuo.dynamic;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/18 20:54
 * @description :  add description here
 */
public class UserServiceDefinitionParser implements BeanDefinitionParser {
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserService.class);
        String dao = element.getAttribute("dao");
        beanDefinitionBuilder.addPropertyReference("userDao", dao);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //注册bean定义
        parserContext.registerBeanComponent(new BeanComponentDefinition(beanDefinition, "userService"));
        return null;
    }
}
