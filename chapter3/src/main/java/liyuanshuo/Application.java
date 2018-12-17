package liyuanshuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;

import javax.sql.DataSource;

/**
 * @author liyuanshuo
 * @Author : liyuanshuo
 * @Date : 2018/12/13 14:22
 * @Description :  add description here
 * @Version 1.0
 */
@SpringBootApplication
@EnableTransactionManagement    /**启用自定义的事务管理器，通过注解的方式*/
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {
    /**注解自定义事务管理器**/
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(applicationBuilder.getClass());
    }


    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);
    }
}
