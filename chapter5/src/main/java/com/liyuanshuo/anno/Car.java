package com.liyuanshuo.anno;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 19:25
 * @description :  add description here
 */

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Component
public class Car {
    private Integer maxSpeed;
    private String brand;
    private Double price;

    public static String HONG_QI = "中文红旗";

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
