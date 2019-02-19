package com.cqu.dao.mybatis;

import com.cqu.domain.Forum;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/19 20:14
 * @description :  add description here
 */
@Repository
public class ForumMybatisTemplateDao {
    private SqlSessionTemplate sessionTemplate;

    @Autowired
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public Forum getForum(int forumId){
        return sessionTemplate.selectOne("com.cqu.dao.mybatis.ForumMybatisDao,getForum", forumId);
    }

    public Forum getForum2(int forumId){
        ForumMybatisDao forumMybatisDao = sessionTemplate.getMapper(ForumMybatisDao.class);
        return forumMybatisDao.getForum(forumId);
    }
}
