package com.cqu.connleak;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/14 14:02
 * @description :  add description here
 */
@Service("userService")
public class HiberUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void logon(String userName){
        System.out.println( userName + " : logon method");
    }

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("multithread/applicationContext.xml");
        HiberUserService service = context.getBean("userService", HiberUserService.class);

        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");

        BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();

        //插入一条记录，初始分数为10
        jdbcTemplate.execute("INSERT INTO t_user(user_name,password,score,last_logon_time) VALUES('tom','123456',10,"+System.currentTimeMillis()+")");
        //调用工作在无事务环境下的服务类方法,将分数添加20分
        service.logon("tom");
        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
