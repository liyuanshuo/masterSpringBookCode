package com.cqu.introduce;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 21:40
 * @description :  add description here
 */
public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformace> performaceRecord = new ThreadLocal<MethodPerformace>();
    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformace mp = performaceRecord.get();
        if(mp == null){
            mp = new MethodPerformace(method);
            performaceRecord.set(mp);
        }else{
            mp.reset(method);
        }
    }
    public static void end() {
        System.out.println("end monitor...");
        MethodPerformace mp = performaceRecord.get();
        mp.printPerformace();
    }

}
