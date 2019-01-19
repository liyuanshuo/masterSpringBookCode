package com.liyuanshuo.tagdepend;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/19 17:08
 * @description :  add description here
 */
public class Boss {
    private String carId;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "carId='" + carId + '\'' +
                '}';
    }
}
