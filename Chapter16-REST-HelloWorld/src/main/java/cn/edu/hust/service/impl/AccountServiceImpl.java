package cn.edu.hust.service.impl;

import cn.edu.hust.dao.AccountDao;
import cn.edu.hust.domain.Account;
import cn.edu.hust.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public void transfer(Account orgin, Account des, int money) {
        accountDao.out(orgin,money);
        //int i=1/0;
        accountDao.in(des,money);
    }


    public List<Account> findList()
    {
        return accountDao.findList();
    }
}
