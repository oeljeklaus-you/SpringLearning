package cn.edu.hust;

import cn.edu.hust.xmlAOP.Audience;
import cn.edu.hust.xmlAOP.MoviePerformance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class MoviePerformanceTest {

    @Autowired
    private MoviePerformance moviePerformance;

    @Test
    public void test()
    {
        moviePerformance.perform();
    }
}
