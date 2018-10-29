package cn.edu.hust;

import cn.edu.hust.autowriting.domain.CDPlayer;
import cn.edu.hust.autowriting.domain.SgtPeppers;
import cn.edu.hust.javaConfig.domain.AnimalCryAndRun;
import cn.edu.hust.javaConfig.domain.Cat;
import cn.edu.hust.javaConfig.domain.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AnimalCryAndRun.class,Dog.class})
public class AnimalCryAndRunTest {
    @Autowired
    private Dog dog;

    @Autowired
    private AnimalCryAndRun animalCryAndRun;

    @Test
    public void testCry()
    {
        animalCryAndRun.cry();
    }

    @Test
    public void testRun()
    {
        animalCryAndRun.run();
    }
}
