package cn.edu.hust.config;

import cn.edu.hust.domain.Account;
import cn.edu.hust.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

@Configuration
public class JavaConfig {
    @Bean
    public HessianProxyFactoryBean accoutService()
    {
        HessianProxyFactoryBean hessianProxyFactoryBean=new HessianProxyFactoryBean();
        hessianProxyFactoryBean.setServiceUrl("http://localhost:8080/accountService.Service");
        hessianProxyFactoryBean.setServiceInterface(AccountService.class);
        return hessianProxyFactoryBean;
    }
}
