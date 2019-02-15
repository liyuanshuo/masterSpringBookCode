package com.cqu.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 17:10
 * @description :  add description here
 */
@Service
public class ForumService {
    private UserService userService;

    @Transactional(propagation = Propagation.NEVER)
    public void addTopic(){
        userService.addCredits();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
