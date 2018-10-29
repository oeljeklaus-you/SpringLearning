package cn.edu.hust;

import cn.edu.hust.autowriting.domain.CDPlayer;
import cn.edu.hust.autowriting.domain.SgtPeppers;
import cn.edu.hust.autowriting.interfaces.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SgtPeppers.class,CDPlayer.class})
public class CDPlayerTest {
    /**
     * Spring会自动注入到这个实体类中
     */
    @Autowired
    private CompactDisc cd;

    @Autowired
    private CDPlayer cdPlayer;
    /**
     * 调用这个类的方法可以看出结果
     */
    @Test
    public void cdShouldNotBeNull()
    {
        cd.play();
    }

    @Test
    public void player()
    {
        cdPlayer.play();
    }
}
