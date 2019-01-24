package com.cqu;

import com.cqu.anno.NeedTest;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 15:53
 * @description :  add description here
 */
public class NaiveWaiter implements Waiter {
    public void greetTo(String clientName) {
        System.out.println("NaiveWaiter:greet to "+clientName+"...");
    }
    @NeedTest
    public void serveTo(String clientName){
        System.out.println("NaiveWaiter:serving "+clientName+"...");
    }
    public void smile(String clientName,int times){
        System.out.println("NaiveWaiter:smile to  "+clientName+ times+"times...");
    }
}
