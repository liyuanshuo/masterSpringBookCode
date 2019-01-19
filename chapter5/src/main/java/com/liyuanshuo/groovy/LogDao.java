package com.liyuanshuo.groovy;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 15:09
 * @description :  add description here
 */
public class LogDao {
    private String dataProvider;

    public void saveLog(){
        System.out.println("Saving Log........");
    }

    public void setDataProvider(String dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void init(){
        System.out.println("initMethod........");
    }

    public void destroy(){
        System.out.println("destroyMethod........");
    }

}
