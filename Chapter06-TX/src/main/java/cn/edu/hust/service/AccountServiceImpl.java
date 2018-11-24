package cn.edu.hust.service;

import cn.edu.hust.dao.AccountDao;
import cn.edu.hust.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDao;

    public void transfer(Account orgin, Account des, int money) {
        accountDao.out(orgin,money);
        //int i=1/0;
        accountDao.in(des,money);
    }
}
