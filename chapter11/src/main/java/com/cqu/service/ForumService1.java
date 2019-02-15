package com.cqu.service;

import com.cqu.dao.ForumDao;
import com.cqu.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/15 17:12
 * @description :  add description here
 */
@Service
public class ForumService1 {
    private ForumDao forumDao;
    private TransactionTemplate transactionTemplate;

    @Autowired
    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }
    @Autowired
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void addForum(final Forum forum){
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                forumDao.addForum(forum);
            }
        });
    }

}
