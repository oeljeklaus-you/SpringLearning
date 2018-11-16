package cn.edu.hust.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
/**
@Configuration
@EnableWebMvcSecurity**/
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //inMemoryAuthentication()启用内存用户存储
        /**
         * withUser()为内存用户存储添加新的用户,这个方法参数是username
         *这里我们添加了两个用户,一个是user,一个是admin,密码均为password,两个分别授予两个角色
         * 一个是USER角色,admin拥有角色为USER和ADMIN
         */
        /**
        auth.inMemoryAuthentication().withUser("username")
                .password("password").roles("USER").and()
                .withUser("admin").password("password")
                .roles("USER","ADMIN");**/
        //auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().authorizeRequests().mvcMatchers("/home.do").hasRole("ADMIN")
                .anyRequest().permitAll();
    }
}
