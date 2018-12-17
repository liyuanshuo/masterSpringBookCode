package liyuanshuo.context;

import liyuanshuo.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author : liyuanshuo
 * Date : 2018/12/18 0:33
 * Description :  add description here
 * Version 1.0
 */
@Configuration
public class Beans {
    @Bean(name = "car")
    public Car builder(){
        Car car = new Car();
        car.setBrand("解放123");
        car.setMaxSpeed(200);
        return car;
    }
}
