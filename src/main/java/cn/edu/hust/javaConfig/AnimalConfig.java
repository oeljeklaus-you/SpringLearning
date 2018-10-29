package cn.edu.hust.javaConfig;

import cn.edu.hust.javaConfig.domain.Cat;
import cn.edu.hust.javaConfig.domain.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 采用java的配置，这样的好处是与java代码无异，但是要记住不要和业务代码混合
 * @ComponentScan该注解表示需要扫描那个包
 */
@ComponentScan( basePackages= {"cn.edu.hust.javaConfig"})
@Configuration
public class AnimalConfig
{
    /**
     * 使用@Bean标签来表示一个bean，一般方法的返回名字和bean的名字一样
     * @return
     */
    @Bean
    public Cat cat()
    {
        return new Cat();
    }

    @Bean
    public Dog dog()
    {
        return new Dog();
    }
}
