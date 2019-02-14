package com.cqu.entity;

import com.cqu.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/14 16:21
 * @description :  add description here
 */
@Service("userService")
public class HibernateUserService {

    @Autowired
    public HibernateTemplate hibernateTemplate;

    public void testUser(){
        User user = (User) hibernateTemplate.get("User", "myName");
//        User simpleUser =  (User)hibernateTemplate.get("SimpleUser","tom");
//        simpleUser.setPassword("c");
//        hibernateTemplate.flush();

        user.setPassword("d");
        hibernateTemplate.flush();
        hibernateTemplate.clear();


        user = (User)hibernateTemplate.get("User",user.getUserName());
        user.setPassword("c");
        hibernateTemplate.flush();
        hibernateTemplate.clear();
    }

    /**
     *@author:  liyuanshuo
     *@dateTime:  2019/2/14 16:33
     *@description: 批量保存
     *@param:  null
     *@return:  
     *@other information: to add other information here
     */
    public <T> void saveBatch(Set<T> objList){
        if (objList == null || objList.size() == 0){
            return;
        }
        int i = 0;
        List<T> batchObjList = new ArrayList<T>();
        for (T obj: objList) {
            hibernateTemplate.save(obj);
            batchObjList.add(obj);
            if (++i % 10 == 0){
                hibernateTemplate.flush();
                hibernateTemplate.clear();
                batchObjList.clear();
            }
        }
    }

    /**
     *@author:  liyuanshuo
     *@dateTime:  2019/2/14 17:03
     *@description: 将对象列表从一级缓存中清除
     *@param:  null
     *@return:  
     *@other information: to add other information here
     */
    public <T> void evict(List<T> objList){
        for (T obj: objList) {
            hibernateTemplate.evict(obj);
        }
    }

    public void batachUpdateTest(){
        Set<User> users = new HashSet<User>();
        for (int i = 0; i < 30; i++) {
            User user = new User();
            user.setUserName("name" + i);
            user.setPassword("123456");
            user.setScore(10);
            users.add(user);
        }
        saveBatch(users);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("entity/applicationContext.xml");
        HibernateUserService service = (HibernateUserService) ctx.getBean("userService");


        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());
        //插入一条记录，初始分数为10
        jdbcTemplate.execute(String.format("INSERT INTO t_user VALUES('myName','123456', '10', '%s')", dateFormat.format(currentDate).toString()));
        //调用工作在无事务环境下的服务类方法,将分数添加20分
        service.testUser();
        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='myName'");
         try {
             Thread.sleep(100000);
         } catch (InterruptedException e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         }
    }
}
