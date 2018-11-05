package cn.edu.hust.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Controller注解表示控制器，该注解基于@Component注解
 * 带有这个注解会声明Spring上下文中的一个bean
 */
@Controller
public class HomeController {

    /**
     * @RequestMapping注解表示要处理那个请求，value表示请求的路径，method表示处理请求的方法是那种
     * @return 返回的值表示需要渲染的视图名称 DispatchServlet要求视图解析器将这个逻辑的视图转化为实际视图
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home()
    {
        return "home";
    }
}
