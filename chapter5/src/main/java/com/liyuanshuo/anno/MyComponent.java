package com.liyuanshuo.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/11 19:55
 * @description :  add description here
 */
@Component
public class MyComponent {
    @Autowired(required = false)
    private List<Plugin> plugins;

    @Autowired
    private Map<String, Plugin> pluginMaps;

    public List<Plugin> getPlugins() {
        return plugins;
    }
}
