package cn.edu.hust.domain;

import cn.edu.hust.interfaces.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * @Component表示该类是一个组件类
 */
@Component
public class SgtPeppers implements CompactDisc {
    private String title="hello,ShangHai!";
    private String artist="nike";
    public void play() {
        System.out.println("Played "+title+" by "+artist);
    }
}
