package com.cqu.advisor;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 21:22
 * @description :  add description here
 */
public class GreetingComposablePointcut {
    public Pointcut getIntersectionPointCut(){
        ComposablePointcut composablePointcut = new ComposablePointcut();
        Pointcut pointcut1 = new ControlFlowPointcut(WaiterDelegate.class, "service");
        NameMatchMethodPointcut pointcut2 = new NameMatchMethodPointcut();
        pointcut2.addMethodName("greetTo");
        return composablePointcut.intersection(pointcut1).intersection((Pointcut) pointcut2);
    }
}
