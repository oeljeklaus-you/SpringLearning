package cn.edu.hust.controller;

import cn.edu.hust.domain.Account;
import cn.edu.hust.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccounController {
    @Autowired
    private AccountService accountService;

    /**
     * 最简单的方式是在方法的返回类型前使用@ResponseBody
     * @return
     */
    @RequestMapping("/findList")
    public @ResponseBody  List<Account> findList()
    {
        return accountService.findList();
    }

    /**
     * 如果请求头是application/json,Jackson2将JSON转化为对象传递到方法中保存
     * @param account
     */
    @RequestMapping(value = "/saveAccount",method = RequestMethod.POST,consumes= "application/json")
    public void saveAccount(@RequestBody Account account)
    {
        accountService.saveAccount(account);
    }
}
