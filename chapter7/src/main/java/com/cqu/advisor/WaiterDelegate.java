package com.cqu.advisor;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 21:09
 * @description :  add description here
 */
public class WaiterDelegate {
    private Waiter waiter;

    public void service(String clientName){
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
