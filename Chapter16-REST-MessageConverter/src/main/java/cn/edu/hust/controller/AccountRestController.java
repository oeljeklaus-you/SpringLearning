package cn.edu.hust.controller;

import cn.edu.hust.domain.Account;
import cn.edu.hust.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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


    //如果遇到查询不到用户给客户端一个反馈表示没有找到这里使用ResponseEntity对象表示
    @RequestMapping("/findOne/{id}")
    public ResponseEntity<Account> findOneByEntity(@PathVariable int id)
    {
        Account account=accountService.findOne(id);
        HttpStatus httpStatus=account==null?HttpStatus.NOT_FOUND:HttpStatus.OK;
        return new ResponseEntity<Account>(account,httpStatus);
    }

}
