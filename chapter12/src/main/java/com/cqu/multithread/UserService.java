package com.cqu.multithread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/14 21:09
 * @description :  add description here
 */
@Service("userService")
public class UserService extends BaseService {
    private final JdbcTemplate jdbcTemplate;

    private final ScoreService scoreService;

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate, ScoreService scoreService) {
        this.jdbcTemplate = jdbcTemplate;
        this.scoreService = scoreService;
    }

    public void logon(String userName){
        System.out.println("before userService.updateLastLogonTime method .......");
        updateLastLogonTime(userName);
        System.out.println("after userService.updateLastLogonTime method .......");
    }

    private void updateLastLogonTime(String userName){
        String sql = "UPDATE t_user u SET u.last_logon_time = ? WHERE user_name =?";
        //处理时间格式，首先确定格式，然后再将时间按照固定的格式进行转换，由于数据库中采用的是字符的形式，最终要加上toString()方法
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());
        jdbcTemplate.update(sql, dateFormat.format(currentDate).toString(), userName);
    }

    private class MyThread extends Thread{
        private ScoreService scoreService;
        private String userName;
        private int toAdd;

        private MyThread(ScoreService scoreService, String userName, int toAdd) {
            this.scoreService = scoreService;
            this.userName = userName;
            this.toAdd = toAdd;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("before scoreService.addScor method...");
            scoreService.addScore(userName, toAdd);
            System.out.println("after scoreService.addScor method...");
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("multithread/applicationContext.xml");
        UserService service = (UserService) ctx.getBean("userService");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        //插入一条记录，初始分数为10
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());
        jdbcTemplate.execute(String.format("INSERT INTO t_user(user_name,password,score,last_logon_time) VALUES('tom','123456',10,'%s')", dateFormat.format(currentDate).toString()));


        //调用工作在无事务环境下的服务类方法,将分数添加20分
        System.out.println("before userService.logon method...");
        service.logon("tom");
        System.out.println("after userService.logon method...");
        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
