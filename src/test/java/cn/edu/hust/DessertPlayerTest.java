package cn.edu.hust;

import cn.edu.hust.cancelMulti.domain.Cake;
import cn.edu.hust.cancelMulti.domain.Cookie;
import cn.edu.hust.cancelMulti.domain.IceCream;
import cn.edu.hust.cancelMulti.interfaces.Dessert;
import cn.edu.hust.cancelMulti.service.DessertPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Cake.class, Cookie.class, IceCream.class, DessertPlayer.class})
public class DessertPlayerTest {
    @Autowired
    private Cake cake;

    @Autowired
    private Cookie cookie;

    @Autowired
    private IceCream iceCream;

    @Autowired
    private DessertPlayer dessertPlayer;

    @Test
    public void testPrintName()
    {
        dessertPlayer.printDessert();
    }
}
