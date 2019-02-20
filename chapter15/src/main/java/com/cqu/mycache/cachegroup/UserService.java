package com.cqu.mycache.cachegroup;

import com.cqu.mycache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/20 16:45
 * @description :  add description here
 */
@Service(value = "cacheGroupUserServcie")
public class UserService {
    private Map<Integer, User> ppl = new HashMap<Integer, User>();
    {
        ppl.put(1, new Member("1", "w1"));
        ppl.put(2, new Visitor("2", "w2"));
    }

    @Caching(cacheable = {
            @Cacheable(value = "members", condition = "#obj instanceof T(com.cqu.mycache.cachegroup.Member)"),
            @Cacheable(value = "visitors", condition = "#obj instanceof T(com.cqu.mycache.cachegroup.Visitor)")
    })
    public User getUser(User obj) {
        return ppl.get(Integer.valueOf(obj.getUserId()));
    }
}
