package cn.edu.hust.controller;

import cn.edu.hust.domain.Account;
import cn.edu.hust.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/transfer")
    public String transfer()
    {
        Account jack=new Account(1,"jack",10000);
        Account marry=new Account(2,"marry",10000);
        accountService.transfer(jack,marry,100);
        return "success";
    }
}
