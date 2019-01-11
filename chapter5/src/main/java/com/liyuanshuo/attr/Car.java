package com.liyuanshuo.attr;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 20:51
 * @description :  add description here
 */
public class Car {
    private Integer maxSpeed;
    private String brand;
    private Double price;

    public static String HONG_QI = "红旗";

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maxSpeed=" + maxSpeed +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
