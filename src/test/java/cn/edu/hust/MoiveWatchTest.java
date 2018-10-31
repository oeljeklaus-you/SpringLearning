package cn.edu.hust;

import cn.edu.hust.aop.MoiveWatch;
import cn.edu.hust.aop.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ MoiveWatch.class,Person.class} )
public class MoiveWatchTest {
    @Autowired
    private Person person;

    @Autowired
    private MoiveWatch moiveWatch;

    @Test
    public void testWatch()
    {
        moiveWatch.watch();
    }
}
