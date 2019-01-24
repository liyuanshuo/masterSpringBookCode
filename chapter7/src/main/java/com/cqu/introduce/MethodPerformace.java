package com.cqu.introduce;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 21:32
 * @description :  add description here
 */
public class MethodPerformace {

    private long begin;
    private long end;
    private String serviceMethod;

    public void setEnd(long end) {
        this.end = end;
    }

    public MethodPerformace(String serviceMethod) {
        this.serviceMethod = serviceMethod;
    }

    public void printPerformace(){
        setEnd(System.currentTimeMillis());
        System.out.println(serviceMethod + " 花费 " + (this.end - this.begin)+ " 毫秒 ");
    }

    public void reset(String serviceMethod){
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

}
