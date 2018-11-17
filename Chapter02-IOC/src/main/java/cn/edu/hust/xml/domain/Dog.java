package cn.edu.hust.xml.domain;

import cn.edu.hust.xml.interfaces.Animal;

public class Dog implements Animal{
    public void cry() {
        System.out.println("the dog cry ou ou ou");
    }

    public void run() {
        System.out.println("the dog run by four foot");
    }
}
