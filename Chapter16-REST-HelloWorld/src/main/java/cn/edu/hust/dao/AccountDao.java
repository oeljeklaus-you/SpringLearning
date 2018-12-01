package cn.edu.hust.dao;

import cn.edu.hust.domain.Account;

import java.util.List;


public interface AccountDao {
    void in(Account inner, int money);

    void out(Account outer, int money);

    List<Account> findList();
}
