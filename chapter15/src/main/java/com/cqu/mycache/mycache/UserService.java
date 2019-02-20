package com.cqu.mycache.mycache;

import com.cqu.mycache.domain.User;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/20 19:45
 * @description :  add description here
 */
public class UserService {
    private CacheManager<User> cacheManager;

    public UserService() {
        /* 构造一个缓存管理器 */
        cacheManager = new CacheManager<User>();
    }

    public User getUserById(String userId) {
        /* 首先查询缓存 */
        User result = cacheManager.getValue(userId);
        if(result!=null) {
            /* 如果在缓存中，则直接返回缓存的结果 */
            System.out.println("从缓存中查询..."+userId);
            return result;
        }
        /* 否则到数据库中查询 */
        result = getFromDB(userId);
        if(null != result) {
            /* 将数据库查询的结果更新到缓存中 */
            cacheManager.addOrUpdateCache(userId, result);
        }
        return result;
    }

    public void reload() {
        cacheManager.evictCache();
    }

    private User getFromDB(String userId) {
        System.out.println("从数据库中查询..."+userId);
        return new User(userId);
    }

}
