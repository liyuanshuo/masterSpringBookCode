package com.cqu.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 15:49
 * @description :  add description here
 */
@Aspect
public class TestAspect {
    //    @Before("execution(public * *(..))")
//	public void allPublicFun(){
//	    System.out.println("allPublicFun() executed!");
//	}
//    @AfterReturning("execution(* *To(..))")
//    public void allToFun(){
//    	System.out.println("allToFun() executed!");
//    }
//    @Before("execution(* com.cqu.aspectj.fun.Waiter.*(..))")
//    public void allWaiterFun(){
//    	System.out.println("allWaiterFun() executed!");
//    }
//    @Before("execution(* com.cqu.aspectj.fun.Waiter+.*(..))")
//    public void allChildClassFun(){
//    	System.out.println("allChildClassFun() executed!");
//    }
//	@Before("execution(* joke(Object,int)))")
    @Before("args(Object,*)")
    public void jokeFun(){
        System.out.println("jokeFun() executed!");
    }
    //    @AfterReturning("@annotation(com.cqu.anno.NeedTest)")
//    public void atAnnotaionTest(){
//    	System.out.println("atAnnotaionTest() executed!");
//    }
//    @AfterReturning("args(String)")
//    public void argsTest(){
//    	System.out.println("argsTest() executed!");
//    }
//    @AfterReturning("@args(Monitorable)")
//    public void atArgsTest(){
//    	System.out.println("atArgsTest() executed!");
//    }
//    @Before("within(com.cqu.aspectj.fun.Waiter)")
//    public void withinTest(){
//    	System.out.println("withinTest() executed!");
//    }
//    @Before("@within(com.cqu.aspectj.fun.Monitorable)")
//	public void atWithinTest() {
//		System.out.println("atWithinTest() executed!");
//	}
    @AfterReturning("this(com.cqu.Seller)")
    public void thisTest(){
        System.out.println("thisTest() executed!");
    }
    public int getOrder() {
        // TODO Auto-generated method stub
        return 1;
    }
}
