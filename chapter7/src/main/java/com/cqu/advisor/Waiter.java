package com.cqu.advisor;

import com.cqu.aop.BeanSelfProxyAware;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 20:55
 * @description :  add description here
 */
public class Waiter implements BeanSelfProxyAware {

    private Waiter waiter;
    public void setSelfProxy(Object object) {
        waiter = (Waiter) object;
    }

    public void serveTo(String name){
        System.out.println("waiter serving " + name + "........");
    }

    public void greetTo(String name){
        System.out.println("waiter greet to " + name + "........");
    }
}
