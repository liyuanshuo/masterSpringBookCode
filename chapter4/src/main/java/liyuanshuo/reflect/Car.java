package liyuanshuo.reflect;

/**
 * Author : liyuanshuo
 * Date : 2018/12/18 1:18
 * Description :  add description here
 * Version 1.0
 */
public class Car {
    private String brand;
    private String color;
    private Integer maxSpeed;

    public Car(){
        System.out.println("init car!!");
    }

    public Car(String brand, String color, Integer maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void introduce(){
        System.out.println("brand:"+brand+";color:"+color+";maxSpeed:"+maxSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
