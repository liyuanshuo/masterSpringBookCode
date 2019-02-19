package com.cqu.dao.hibraw;

import com.cqu.domain.Topic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 20:06
 * @description :  add description here
 */
@Repository
public class TopicHibernateDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addTopic(Topic topic){
        sessionFactory.getCurrentSession().save(topic);
    }
}
