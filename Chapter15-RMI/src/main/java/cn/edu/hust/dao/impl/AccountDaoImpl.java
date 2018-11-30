package cn.edu.hust.dao.impl;

import cn.edu.hust.dao.AccountDao;
import cn.edu.hust.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void in(Account inner, int money) {
        String sql="update account set money=money-? where username = ?";

        jdbcTemplate.update(sql,new Object[]{money,inner.getUsername()});
    }

    public void out(Account outer, int money) {
        String sql="update account set money=money+? where username = ?";

        jdbcTemplate.update(sql,new Object[]{money,outer.getUsername()});
    }
}
