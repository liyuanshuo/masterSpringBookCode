package com.cqu.dao.hibraw;

import com.cqu.domain.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 20:04
 * @description :  add description here
 */
@Repository
public class PostHibernateDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPost(Post post){
        sessionFactory.getCurrentSession().save(post);
    }

    public Post getPost(int postId){
        return (Post) sessionFactory.getCurrentSession().get(Post.class, postId);
    }
}
