package cn.edu.hust.cancelMulti.service;

import cn.edu.hust.cancelMulti.interfaces.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = {"cn.edu.hust.cancelMulti"})
@Component
public class DessertPlayer {
    /**
     * 由于这里有三个实现了该接口的类,那么如果直接运行就会产生歧义,也就是NoUniqueBeanDefinitionExecption
     * 我们如下解决整个歧义呢?
     * 1.我们可以使用限定符来进行qualifier 我们可以在我们选定的类上加入@Primary注解
     * 2.对于一般的xml配置文件,我们可以将属性primary设置为true
     */
    /**
     * 使用@Qualifier注解可以更小的限制,这里注解名字和类名称一致,其实主要是id为类的名字首字母小写
     */
    @Autowired
    @Qualifier("cold")
    private Dessert dessert;

    public void printDessert()
    {
        dessert.printName();
    }
}
