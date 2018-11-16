package cn.edu.hust.controller;

import cn.edu.hust.bean.Person;
import cn.edu.hust.exception.BeanNotFoudException;
import cn.edu.hust.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * @Controller注解表示控制器，该注解基于@Component注解
 * 带有这个注解会声明Spring上下文中的一个bean
 */
@Controller
public class HomeController {
    @Autowired
    private PersonServiceImpl personService;
    /**
     * @RequestMapping注解表示要处理那个请求，value表示请求的路径，method表示处理请求的方法是那种
     * @return 返回的值表示需要渲染的视图名称 DispatchServlet要求视图解析器将这个逻辑的视图转化为实际视图
     */
    @RequestMapping("/home.do")
    public String home()
    {
        return "home";
    }

    @RequestMapping("/showPersonMsg")
    public String showPersonmsg(Model mode)
    {
        Person person=new Person(1,"lili",23);
        mode.addAttribute("person",person);
        return "personInfo";
    }

    //@RequestParam 处理查询参数
    @RequestMapping("/query")
    public String queryById(Model model,@RequestParam  int id)
    {
        System.out.println(id);
        Person person=new Person(1,"lili",23);
        model.addAttribute("person",person);
        return "personInfo";
    }

    //如果路径的参数名称和参数的名称相同可以省略@PathVariable的value，这里的路径的参数需要用{}括起来
    @RequestMapping("/queryByPath/{id}")
    public String queryByPath(Model model,@PathVariable("id") int id)
    {
        System.out.println(id);
        //Person person=personService.findOneById(id);
        Person person=personService.findOneByHibernate(id);
        model.addAttribute("person",person);
        return "personInfo";
    }

    @RequestMapping("/preRegister")
    public String preRegister()
    {
        return "regist";
    }

    //页面的name属性和接收参数的对象的属性名要一致，这样才能进行接收值
    //@Valid注解表示这个参数需要校验,Errors表示如果有错误就返回，这个类要跟在@Valid后面
    @RequestMapping("/register")
    public String register(Model model, @Valid Person person, Errors errors)
    {
        if(errors.hasErrors())
            return "regist";
        model.addAttribute("person",person);
        return "personInfo";
    }

    @RequestMapping("showTest")
    public String showTest(Model model)
    {
        model.addAttribute("person",new Person());
        return "test";
    }

    @RequestMapping("showFileUpload")
    public String showFileUpload()
    {
        return "fileUpload";
    }

    @RequestMapping("/uploadUrl")
    public String processFileUpload(Model model,
                                    @RequestPart("images")MultipartFile part)
            throws IOException {
        String basedir="/Users/youyujie/Documents/SpringWeb/src/main/resources/file/";
        part.transferTo(new File(basedir+part.getOriginalFilename()));
        model.addAttribute("msg","上传成功");
        return "success";
    }

    @RequestMapping("showException")
    public String processException() throws BeanNotFoudException {
        if(true)
         throw new BeanNotFoudException("404");
        return "success";
    }

    @RequestMapping("processException")
    public String process_Exception() throws Exception {
        if(true) throw new Exception("500");
        return "home";
    }

    /**
    //这个方法可以处理该控制器抛出的Exception异常
    @ExceptionHandler(Exception.class)
    public String handlerException()
    {
        return "error/error";
    }**/

    @RequestMapping("showPersonByForward")
    public String showPersonByForward(RedirectAttributes model)
    {
        model.addAttribute("id",1);
        model.addFlashAttribute("person",new Person(2,"tr",23));
        return "redirect:/showPersonByFlash";
    }

    @RequestMapping("showPersonByFlash")
    public String showPersonByFlash()
    {
        return "personInfo";
    }

    @RequestMapping("insertPerson")
    public String insertPerson(Model model)
    {
        Person person=new Person(4,"teng",34);
        this.personService.insertPerson(person);
        model.addAttribute("msg","插入成功");
        return "success";
    }
}
