package cn.edu.hust.config;

import cn.edu.hust.domain.Account;
import cn.edu.hust.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

@Configuration
public class JavaConfig {
    /**
     * 使用RMI发布服务,默认的端口号是本机的1099端口
     * @param accountService
     * @return
     */
    @Bean
    public RmiServiceExporter rmiServiceExporter(AccountService accountService)
    {
        RmiServiceExporter rmiServiceExporter=new RmiServiceExporter();

        rmiServiceExporter.setService(accountService);

        rmiServiceExporter.setServiceName("accountService");

        rmiServiceExporter.setServiceInterface(AccountService.class);

        return rmiServiceExporter;
    }


    /**
     * 客户端配置:使用DI查找服务
     * @return

    @Bean
    public RmiProxyFactoryBean rmiProxyFactoryBean()
    {
        RmiProxyFactoryBean rmiProxyFactoryBean=new RmiProxyFactoryBean();

        rmiProxyFactoryBean.setServiceUrl("rmi://localhost/accoutService");

        rmiProxyFactoryBean.setServiceInterface(AccountService.class);

        return rmiProxyFactoryBean;
    } */

    /**
     * 在服务端发布远程服务
     * @param accountService
     * @return
     */

    @Bean
    public HessianServiceExporter hessianServiceExporter(AccountService accountService)
    {
        HessianServiceExporter hessianServiceExporter=new HessianServiceExporter();
        hessianServiceExporter.setService(accountService);
        hessianServiceExporter.setServiceInterface(AccountService.class);
        return hessianServiceExporter;
    }

    @Bean
    public HandlerMapping handlerMapping()
    {
        SimpleUrlHandlerMapping simpleUrlHandlerMapping=new SimpleUrlHandlerMapping();
        Properties properties=new Properties();
        properties.setProperty("/accountService.Service","hessianServiceExporter");
        simpleUrlHandlerMapping.setMappings(properties);
        return simpleUrlHandlerMapping;
    }

    @Bean
    public HttpInvokerServiceExporter httpInvokerServiceExporter(AccountService accountService)
    {
        HttpInvokerServiceExporter httpInvokerServiceExporter=new HttpInvokerServiceExporter();
        httpInvokerServiceExporter.setService(accountService);
        httpInvokerServiceExporter.setServiceInterface(AccountService.class);
        return httpInvokerServiceExporter;
    }


    //默认的服务端口是http://localhost:8080/AccountService
    @Bean
    public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter()
    {
        SimpleJaxWsServiceExporter simpleJaxWsServiceExporter=new SimpleJaxWsServiceExporter();
        simpleJaxWsServiceExporter.setBaseAddress("http://localhost:8888/AccountService");
        return simpleJaxWsServiceExporter;
    }
}
