package com.cqu.tx;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/14 21:49
 * @description :  add description here
 */
@Service
public class UserHibernateService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void addNotice(){

    }

    public boolean testSession(){
        List<Session> sessions = new ArrayList<Session>();
        sessions.add(getSessionBySessionFactory());
        sessions.add(getSessionBySessionFactory());
        return sessions.get(0) == sessions.get(1) && sessions.get(1) == sessions.get(2);
    }

    private Session getSessionBySessionFactory(){
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }
}
