package com.cqu.mixdao;

import com.cqu.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/14 20:49
 * @description :  add description here
 */
@Service("userService")
public class UserService extends BaseService{

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private ScoreService scoreService;

    public void logon(String userName){
        System.out.println("before userService.updateLastLogonTime()..");
        updateLastLogonTime(userName);
        System.out.println("end userService.updateLastLogonTime()..");

        System.out.println("before scoreService.addScore()..");
        scoreService.addScore(userName, 20);
        System.out.println("end scoreService.addScore()..");
    }

    public void updateLastLogonTime(String userName) {
        User user = hibernateTemplate.get(User.class,userName);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());
        user.setLastLogonTime(dateFormat.format(currentDate).toString());
        hibernateTemplate.update(user);
        hibernateTemplate.flush();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("mixdao/applicationContext.xml");
        UserService service = (UserService) ctx.getBean("userService");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        //插入一条记录，初始分数为10
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());
        jdbcTemplate.execute(String.format("INSERT INTO t_user(user_name,password,score,last_logon_time) VALUES('tom','123456',10,'%s')", dateFormat.format(currentDate).toString()));

        //调用工作在无事务环境下的服务类方法,将分数添加20分
        System.out.println("before userService.logon()..");
        service.logon("tom");
        System.out.println("after userService.logon()..");

        int score = jdbcTemplate.queryForObject("SELECT score FROM t_user WHERE user_name ='tom'", Integer.class);
        System.out.println("score:"+score);
        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");
    }
}
