package com.cqu.programtx;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/14 21:29
 * @description :  add description here
 */
@Service("userService")
public class UserService {

    @Autowired
    private DataSource dataSource;

    private static final String sql = "UPDATE t_user u SET u.score = u.score + ? WHERE user_name =?";

    private PlatformTransactionManager getDataSourceTransactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(this.dataSource);
        return dataSourceTransactionManager;
    }

    public void addScore() throws SQLException {
        final JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(this.dataSource);
        final BasicDataSource basicDataSource = (BasicDataSource) this.dataSource;

        TransactionTemplate transactionTemplate = new TransactionTemplate(getDataSourceTransactionManager());
        System.out.println("before transactionTemplate.execute.......");
        System.out.printf("conn.autocommit(before): %s %n", DataSourceUtils.getConnection(basicDataSource).getAutoCommit());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());
        String beginDate = dateFormat.format(currentDate).toString();

        long begin = System.currentTimeMillis();

        transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
                for (int i = 0; i < 100; i++) {
                    jdbcTemplate.update(sql, 30, "tom");
                }
                return null;
            }
        });
        System.out.println("time elapsed in tx:" + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            jdbcTemplate.update(sql, 30, "tom");
        }
        System.out.println("time elapsed not in tx:" + (System.currentTimeMillis() - begin));
    }


    public static void main(String[] args) throws Throwable {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("programtx/programicTx.xml");
        UserService service = (UserService) ctx.getBean("userService");
        service.addScore();
    }
}
