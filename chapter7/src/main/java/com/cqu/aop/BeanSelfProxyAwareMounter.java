package com.cqu.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;

import java.util.Map;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 20:18
 * @description :  add description here
 */
public class BeanSelfProxyAwareMounter implements SystemBootAddon, ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ApplicationContext applicationContext;

    public void onReady() {
        Map<String, BeanSelfProxyAware> proxyAwareMap = applicationContext.getBeansOfType(BeanSelfProxyAware.class);
        if (proxyAwareMap != null){
            for (BeanSelfProxyAware beanSelfProxyAware : proxyAwareMap.values()){
                beanSelfProxyAware.setSelfProxy(beanSelfProxyAware);
                if (logger.isDebugEnabled()){
                    logger.debug("{}注册自身被代理的实例");
                }
            }
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
