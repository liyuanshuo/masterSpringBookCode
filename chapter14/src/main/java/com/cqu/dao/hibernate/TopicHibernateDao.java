package com.cqu.dao.hibernate;

import com.cqu.domain.Topic;
import org.springframework.stereotype.Repository;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 18:54
 * @description :  add description here
 */
@Repository
public class TopicHibernateDao extends BaseDao{
    public void addTopic(Topic topic){
        getHibernateTemplate().save(topic);
    }

    public Topic getTopicById(int topicId){
        return getHibernateTemplate().get(Topic.class, topicId);
    }
}
