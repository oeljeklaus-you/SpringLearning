package cn.edu.hust;

import cn.edu.hust.xml.domain.Dog;
import cn.edu.hust.xml.service.AnimalPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Dog.class, AnimalPlayer.class})
public class AnimalPlayerTest {
    @Autowired
    private Dog dog;

    @Autowired
    private AnimalPlayer animalPlayer;

    @Test
    public void testPalyer()
    {
        this.animalPlayer.player();
    }
}
