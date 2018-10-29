package cn.edu.hust.cancelMulti.domain;

import cn.edu.hust.cancelMulti.interfaces.Dessert;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cake implements Dessert{
    public void printName() {
        System.out.println("the Dessert name is Cake");
    }
}
