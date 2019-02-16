
package com.cqu.withouttx.hiber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.apache.commons.dbcp.BasicDataSource;

import com.cqu.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liyuanshuo
 */
@Service("hiberService")
public class UserHibernateWithoutTransManagerService {
    
	private final HibernateTemplate hibernateTemplate;

    @Autowired
    public UserHibernateWithoutTransManagerService(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    private void addScore(String userName, int toAdd){
        User user = hibernateTemplate.get(User.class,userName);
        user.setScore(user.getScore()+toAdd);
        //在无事务上下文的环境下，显式调用update将即时向数据库发送SQL
//        hibernateTemplate.flush();
        hibernateTemplate.update(user);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("withouttx/hiber/hiberWithoutTx.xml");
        UserHibernateWithoutTransManagerService service = (UserHibernateWithoutTransManagerService)ctx.getBean("hiberService");

        JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        BasicDataSource basicDataSource = (BasicDataSource)jdbcTemplate.getDataSource();

        //①检查数据源autoCommit的设置
        System.out.println("autoCommit:"+ basicDataSource.getDefaultAutoCommit());

        //②插入一条记录，初始分数为10
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());
        jdbcTemplate.execute(String.format("INSERT INTO t_user(user_name,password,score,last_logon_time) VALUES('tom','123456',10,'%s')", dateFormat.format(currentDate).toString()));

        //③调用工作在无事务环境下的服务类方法,将分数添加20分
        service.addScore("tom",20);
        
        //④查看此时用户的分数
        int score = jdbcTemplate.queryForObject("SELECT score FROM t_user WHERE user_name ='tom'", Integer.class);
        System.out.println("score:"+score);
        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");
    }
}