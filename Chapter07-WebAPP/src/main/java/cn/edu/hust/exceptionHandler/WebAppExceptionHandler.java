package cn.edu.hust.exceptionHandler;

import cn.edu.hust.exception.BeanNotFoudException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebAppExceptionHandler {
    @ExceptionHandler(BeanNotFoudException.class)
    public String handlereanNotFoudException()
    {
        return "error/error";
    }
}
