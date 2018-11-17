package cn.edu.hust.cancelMulti.domain;

import cn.edu.hust.cancelMulti.interfaces.Dessert;
import org.springframework.stereotype.Component;

@Component
public class IceCream implements Dessert
{
    public void printName() {
        System.out.println("the Dessert name is iceCream");
    }
}
