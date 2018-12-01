package cn.edu.hust.controller;

import cn.edu.hust.domain.Account;
import cn.edu.hust.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccounController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findList")
    public List<Account> findList()
    {
        return accountService.findList();
    }
}
