package com.cqu.spel;

import java.util.Date;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:25
 * @description :  add description here
 */
public class CodeGenerator {

    public static String getDim1(){
        return String.valueOf(new Date().getYear()+1900);
    }

    public static String getDim2(){
        return String.valueOf(new Date().getMonth()+1);
    }

    public static String getDim3(){
        return String.valueOf(new Date().getDay());
    }
}
