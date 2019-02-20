package com.cqu.mycache.config;

import com.cqu.mycache.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/20 16:36
 * @description :  add description here
 */
@CacheConfig(cacheNames = "users", keyGenerator = "MyKeyGenerator")
public class UserService {
    @Cacheable
    public User findA(User user) {
        return null;
    }

    @Cacheable
    public User findB(User user) {
        return null;
    }
}
