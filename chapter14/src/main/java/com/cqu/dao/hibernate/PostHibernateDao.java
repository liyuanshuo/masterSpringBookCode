package com.cqu.dao.hibernate;

import com.cqu.domain.Post;
import org.springframework.stereotype.Repository;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 18:11
 * @description :  add description here
 */
@Repository
public class PostHibernateDao extends BaseDao{

    public void addPost(Post post){
        getHibernateTemplate().save(post);
    }

    public Post getPost(int postId){
        return getHibernateTemplate().get(Post.class, postId);
    }
}
