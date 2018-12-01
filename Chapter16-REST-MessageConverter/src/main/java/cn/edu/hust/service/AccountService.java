package cn.edu.hust.service;

import cn.edu.hust.domain.Account;

import java.util.List;

public interface AccountService {
    void transfer(Account orgin, Account des, int money);
    List<Account> findList();

    void saveAccount(Account account);
}
