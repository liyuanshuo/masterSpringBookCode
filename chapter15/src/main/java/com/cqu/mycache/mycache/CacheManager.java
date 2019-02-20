package com.cqu.mycache.mycache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/20 19:45
 * @description :  add description here
 */
public class CacheManager<T> {
    private Map<String,T> cache =
            new ConcurrentHashMap<String,T>();

    public T getValue(Object key) {
        return cache.get(key);
    }

    public void addOrUpdateCache(String key,T value) {
        cache.put(key, value);
    }

    public void evictCache(String key) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    public void evictCache() {
        cache.clear();
    }

}
