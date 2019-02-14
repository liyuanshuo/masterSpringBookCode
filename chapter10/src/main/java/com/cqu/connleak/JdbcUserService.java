package com.cqu.connleak;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.util.Date;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/14 15:54
 * @description :  add description here
 */
@Service("jdbcUserService")
public class JdbcUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void logon(String userName){
        try {
            /* Connection conn = jdbcTemplate.getDataSource().getConnection();**/
            Connection conn = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());

            String sql = "UPDATE t_user SET last_logon_time=? WHERE user_name =?";
            jdbcTemplate.update(sql, new Date(System.currentTimeMillis()), userName);
            Thread.sleep(1000);
            //②模拟程序代码的执行时间
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class UserServiceRunner extends Thread {
        private JdbcUserService userService;
        private String userName;

        public UserServiceRunner(JdbcUserService userService, String userName) {
            this.userService = userService;
            this.userName = userName;
        }

        @Override
        public void run() {
            userService.logon(userName);
        }
    }
    public static void asynchrLogon(JdbcUserService userService, String userName) {
        UserServiceRunner runner = new UserServiceRunner(userService, userName);
        runner.start();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("connleak/applicationContext.xml");
        JdbcUserService userService = (JdbcUserService) ctx.getBean("jdbcUserService");

        /*BasicDataSource basicDataSource = (BasicDataSource) ctx.getBean("dataSource");**/
        BasicDataSource basicDataSource = (BasicDataSource) ctx.getBean("originDataSource");
        JdbcUserService.reportConn(basicDataSource);

        JdbcUserService.asynchrLogon(userService, "tom");
        JdbcUserService.sleep(500);
        JdbcUserService.reportConn(basicDataSource);


        JdbcUserService.sleep(2000);
        JdbcUserService.reportConn(basicDataSource);


        JdbcUserService.asynchrLogon(userService, "john");
        JdbcUserService.sleep(500);
        JdbcUserService.reportConn(basicDataSource);


        JdbcUserService.sleep(2000);
        JdbcUserService.reportConn(basicDataSource);

    }

    private static void reportConn(BasicDataSource basicDataSource) {
        System.out.println("连接数[active:idle]-[" +
                basicDataSource.getNumActive()+":"+basicDataSource.getNumIdle()+"]");
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
