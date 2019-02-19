package com.cqu.dao.hibraw;

import com.cqu.domain.Forum;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 20:07
 * @description :  add description here
 */
@Repository
public class ForumHibernateDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addForum(Forum forum){
        sessionFactory.getCurrentSession().save(forum);
    }

    public void updateForum(Forum forum){
        sessionFactory.getCurrentSession().update(forum);
    }

    public Forum getForum(int forumId){
        return (Forum) sessionFactory.getCurrentSession().get(Forum.class, forumId);
    }

    public long getForumNum(){
        Object object = sessionFactory.getCurrentSession().createQuery("select count(f.forumId) form Forum f").list().iterator();
        return (Long) object;
    }

    public List<Forum> findForumByName(String forumName){
        List list = sessionFactory.getCurrentSession().createSQLQuery("form Forum f where f.forumName like ?").setString(0, forumName+"%").list();
        return (List<Forum>) list;
    }
}
