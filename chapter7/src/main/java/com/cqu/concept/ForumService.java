package com.cqu.concept;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/1/24 13:06
 * @description :  add description here
 */
public class ForumService {

    private TransactionManager transactionManager;
    private PerformanceMonitor performanceMonitor;
    private TopicDao topicDao;
    private ForumDao forumDao;

    public void removeTopic(Integer topicId){
        performanceMonitor.start();
        transactionManager.beginTransaction();

        topicDao.removeTopic(topicId);

        transactionManager.endTransaction();
        performanceMonitor.end();
    }

    public void CreateForum(Forum forum){
        performanceMonitor.start();
        transactionManager.beginTransaction();

        forumDao.create(forum);

        transactionManager.endTransaction();
        performanceMonitor.end();

    }

}
