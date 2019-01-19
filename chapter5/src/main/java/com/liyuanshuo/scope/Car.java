package com.liyuanshuo.scope;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 16:39
 * @description :  add description here
 */
public class Car {
    private String color;
    private String brand;
    private Double price;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
