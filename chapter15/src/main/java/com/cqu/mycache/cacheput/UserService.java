package com.cqu.mycache.cacheput;

import com.cqu.mycache.domain.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/20 16:48
 * @description :  add description here
 */
@Service(value = "cachePutUserServcie")
public class UserService {

    private Map<Integer, User> users = new HashMap<Integer, User>();
    {
        users.put(1, new User("1", "cxh"));
        users.put(2, new User("2", "lkx"));
        users.put(3, new User("3", "wjg"));
    }

    @CachePut(value = "users")
    public User getUser(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }
}

