package cn.edu.hust;

import cn.edu.hust.dao.AccountDao;
import cn.edu.hust.dao.impl.AccountDaoImpl;
import cn.edu.hust.domain.Account;
import cn.edu.hust.service.AccountService;
import cn.edu.hust.service.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountTest {

    @Autowired
    private AccountService accountService;
    @Test
    public void test()
    {
       /**
         * create table account( id int primary key auto_increment,username varchar(50),money int)
         */
        Account jack=new Account(1,"jack",10000);
        Account marry=new Account(2,"marry",10000);
        accountService.transfer(jack,marry,100);
    }
}
