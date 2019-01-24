package com.cqu.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 19:40
 * @description :  add description here
 */
@Component
public class MyDataSource {

    @Value("#{properties['driverClassName']}")
    private String driverClassName;

    @Value("${url}")
    private String url;

    @Value("#{properties['userName']}")
    private String userName;

    @Value("#{properties['password']}")
    private String password;
}
