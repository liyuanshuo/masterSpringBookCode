package com.cqu.dao;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 17:25
 * @description :  add description here
 */
public class ForumDao extends BaseDao {
    public long getForumNum(){
        Object object = getHibernateTemplate().iterate("select  count (f.forumId) from Forum f").next();
        return (Long)object;
    }
}
