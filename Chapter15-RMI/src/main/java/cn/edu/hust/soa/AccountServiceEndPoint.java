package cn.edu.hust.soa;

import cn.edu.hust.domain.Account;
import cn.edu.hust.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Component
@WebService(serviceName = "AccountService")
public class AccountServiceEndPoint {
    @Autowired
    private AccountService accountService;

    //委托给AccountService
    @WebMethod
    public void transfer(Account orgin,Account dest,int money)
    {
        accountService.transfer(orgin,dest,money);
    }

}
