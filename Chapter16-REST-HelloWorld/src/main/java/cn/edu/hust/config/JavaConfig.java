package cn.edu.hust.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
public class JavaConfig {
    @Bean
    public ViewResolver viewResolver(ContentNegotiationManager contentNegotiationManager)
    {
       ContentNegotiatingViewResolver  contentNegotiatingViewResolver= new ContentNegotiatingViewResolver();
        contentNegotiatingViewResolver.setContentNegotiationManager(contentNegotiationManager);
        return contentNegotiatingViewResolver;
    }

    //以bean的形式查找视图
    @Bean
    public ViewResolver beanNameViewResolver()
    {
        return new BeanNameViewResolver();
    }

    //将"accounts"定义为JSON视图
    @Bean
    public View accounts()
    {
        return new MappingJackson2JsonView();
    }
}
