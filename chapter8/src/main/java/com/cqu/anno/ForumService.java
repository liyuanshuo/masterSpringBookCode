package com.cqu.anno;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 15:27
 * @description :  add description here
 */
public class ForumService {

    @NeedTest(value = true)
    public void deleteForum(Integer forumId){
        System.out.println("模拟删除论坛模块 ： " + forumId);
    }

    @NeedTest(value = false)
    public void deleteTopic(Integer topicId){
        System.out.println("模拟删除论坛主题 ： "  + topicId);
    }
}
