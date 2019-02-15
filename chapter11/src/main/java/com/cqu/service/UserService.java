package com.cqu.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 17:07
 * @description :  add description here
 */
@Service
public class UserService {

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addCredits(){}
}
