package cn.edu.hust.service;

import cn.edu.hust.domain.Account;

public interface AccountService {
    void transfer(Account orgin,Account des,int money);
}
