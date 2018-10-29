package cn.edu.hust.xml.service;


import cn.edu.hust.xml.interfaces.Animal;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnimalPlayer {
    private Animal animal;
    private String name;
    private List<String> lists;

    public AnimalPlayer(Animal animal)
    {
        this.animal=animal;
    }

    /**
    public AnimalPlayer(Animal animal,String name,List<String> lists)
    {
        this.animal=animal;
        this.name=name;
        this.lists=lists;
    }**/

    public void player()
    {
        this.animal.cry();
    }

    public void printName()
    {
        System.out.println("the animal is "+name);
    }

    public void printList()
    {
        for(String s:lists)
        {
            System.out.println(s);
        }
    }
}
