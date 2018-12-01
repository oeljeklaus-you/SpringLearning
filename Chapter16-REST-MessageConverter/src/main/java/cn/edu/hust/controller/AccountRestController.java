package cn.edu.hust.controller;

import cn.edu.hust.domain.Account;
import cn.edu.hust.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/account")
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    /**
     * 最简单的方式是在方法的返回类型前使用@ResponseBody
     * @return
     */
    @RequestMapping("/findList")
    public @ResponseBody
    List<Account> findList()
    {
        return accountService.findList();
    }

}
