package liyuanshuo.reflect;

/**
 * Author : liyuanshuo
 * Date : 2018/12/18 1:21
 * Description :  add description here
 * Version 1.0
 */
public class PrivateCar {
    private String color;
    protected void drive(){
        System.out.println("drive private car! the color is:"+color);
    }
}
