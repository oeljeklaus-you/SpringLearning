package cn.edu.hust.javaConfig.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalCryAndRun{
    private Animal animal;

    /**
     * 将这个bean注入到AnimalCryAndRun中
     * @param animal
     */
    @Autowired
    public AnimalCryAndRun(Animal animal) {
        this.animal = animal;
    }

    public void cry()
    {
        this.animal.cry();
    }

    public void run()
    {
        this.animal.run();
    }
}
