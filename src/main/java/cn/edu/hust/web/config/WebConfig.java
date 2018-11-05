package cn.edu.hust.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @EnableWebMvc注解表示启动SpringMVC组件，当然你也可以在XML文件中配置
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"cn.edu.hust.web"})
public class WebConfig extends WebMvcConfigurerAdapter{
    /**
     * 设置视图解析器，如果没有配置，那么将解析所有的包含静态资源，这样配置以后只结果jsp
     * @return
     */
    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setExposeContextBeansAsAttributes(true);
        return internalResourceViewResolver;
    }

    /**
     * 配置静态资源的处理
     * 这样配置要求DispatcherServlet将对静态资源的请求转发到Servlet容器中的默认Servlet中
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
