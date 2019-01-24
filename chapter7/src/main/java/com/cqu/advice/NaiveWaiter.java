package com.cqu.advice;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 16:39
 * @description :  add description here
 */
public class NaiveWaiter implements Waiter{
    public void greetTo(String name) {
        System.out.println("greet to " + name + "......");
    }

    public void serveTo(String name) {
        System.out.println("serve to " + name + "......");
    }
}
