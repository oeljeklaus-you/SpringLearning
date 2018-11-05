package cn.edu.hust.web.dispatch;

import cn.edu.hust.web.config.RootConfig;
import cn.edu.hust.web.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    //指定配置类
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //将DispatchServlet映射到"/"
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}