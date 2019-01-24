package com.cqu.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 19:34
 * @description :  add description here
 */
public class BeforeAdviceTest {

    @Test
    public void testBefore(){
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setInterfaces(target.getClass().getInterfaces());
        proxyFactory.setOptimize(true);
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(advice);

        Waiter proxy = (Waiter) proxyFactory.getProxy();
        proxy.greetTo("john");
        proxy.serveTo("Tom");
    }
}
