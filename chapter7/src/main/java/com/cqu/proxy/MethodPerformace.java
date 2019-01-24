package com.cqu.proxy;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 13:20
 * @description :  add description here
 */
public class MethodPerformace {

    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformace(String serviceMethod) {
        this.serviceMethod = serviceMethod;
    }

    public void printPerformace(){
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(serviceMethod + " total costing time is " + elapse + " ms ");
    }

    public void reset(String serviceMethod){
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

}
