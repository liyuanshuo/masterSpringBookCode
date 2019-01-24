package com.cqu.aspectj.advanced;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 15:37
 * @description :  add description here
 */
public class TestNamePointcut {
    @Pointcut("within(com.cqu.*)")
    private void inPackage(){}

    @Pointcut("execution(* greetTo(..))")
    protected void greetTo(){}

    @Pointcut("inPackage(), greetTo()")
    public void inPkgGreetTo(){}
}
