package com.cqu;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 15:55
 * @description :  add description here
 */
public class NaughtyWaiter implements Waiter {
    public void greetTo(String clientName) {
        System.out.println("NaughtyWaiter:greet to "+clientName+"...");
    }
    public void serveTo(String clientName){
        System.out.println("NaughtyWaiter:serving "+clientName+"...");
    }
    public void joke(String clientName,int times){
        System.out.println("NaughtyWaiter:play "+times+" jokes to "+clientName+"...");
    }
}
