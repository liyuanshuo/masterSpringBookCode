package com.cqu.introduce;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/22 21:36
 * @description :  add description here
 */
public class ForumService {
    public void removeTopic(int topicId) {
        System.out.println("模拟删除Topic记录:"+topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void removeForum(int forumId) {
        System.out.println("模拟删除Forum记录:"+forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
