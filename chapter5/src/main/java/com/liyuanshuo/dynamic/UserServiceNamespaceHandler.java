package com.liyuanshuo.dynamic;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/18 21:11
 * @description :  add description here
 */
public class UserServiceNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("user-service", new UserServiceDefinitionParser());
    }
}
