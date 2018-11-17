package cn.edu.hust.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @EnableAspectJAutoProxy注解表示开启aop
 * 这里@Configuration是必须的,不然在测试的时候仅仅产生一个代理类并没有启用aspectj代理，不会产生实际的bean
 */
@Configuration
@ComponentScan(basePackages ={"cn.edu.hust.aop"} )
@EnableAspectJAutoProxy
@Component
public class MoiveWatch implements Watch{
    public void watch() {
        //int a=1/0;
        System.out.println("watch the donghua moive");
    }
}
