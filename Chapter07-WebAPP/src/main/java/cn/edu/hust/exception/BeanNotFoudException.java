package cn.edu.hust.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "request method result not found")
public class BeanNotFoudException extends Exception {
    public BeanNotFoudException(String message) {
        super(message+" bean no found");
    }
}
