package cn.edu.hust.cancelMulti.domain;

import cn.edu.hust.cancelMulti.interfaces.Dessert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cold")
public class Cookie implements Dessert{
    public void printName() {
        System.out.println("the Dessert name is cookies");
    }
}
