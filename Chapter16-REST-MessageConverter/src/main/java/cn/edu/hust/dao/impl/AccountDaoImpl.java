package cn.edu.hust.dao.impl;

import cn.edu.hust.dao.AccountDao;
import cn.edu.hust.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

   class AccountRowMapper implements RowMapper<Account>
   {
       @Override
       public Account mapRow(ResultSet resultSet, int i) throws SQLException {
           if(resultSet.wasNull()) return null;
           Account account=new Account();
           account.setId(resultSet.getInt(1));
           account.setUsername(resultSet.getString(2));
           account.setMoney(resultSet.getInt(3));
           return account;
       }
   }
    public void in(Account inner, int money) {
        String sql="update account set money=money-? where username = ?";

        jdbcTemplate.update(sql,new Object[]{money,inner.getUsername()});
    }

    public void out(Account outer, int money) {
        String sql="update account set money=money+? where username = ?";

        jdbcTemplate.update(sql,new Object[]{money,outer.getUsername()});
    }

    @Override
    public List<Account> findList() {
        String sql="select * from account";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper(Account.class));
    }

    @Override
    public void saveAccount(Account account) {
        String sql="insert account(username,money) values(?,?)";
        jdbcTemplate.update(sql,new Object[]{account.getUsername(),account.getMoney()});
    }

    @Override
    public Account finOne(int id) {
        String sql="select * from account where id =?";
        try
        {
            return (Account)jdbcTemplate.queryForObject(sql,new Object[]{id},new AccountRowMapper());
        }catch (Exception e)
        {
            return null;
        }

    }
}
