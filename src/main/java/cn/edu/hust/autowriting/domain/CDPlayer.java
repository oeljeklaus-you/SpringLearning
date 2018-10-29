package cn.edu.hust.autowriting.domain;

import cn.edu.hust.autowriting.interfaces.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
    //@Autowired也可以放在这里
    private CompactDisc cd;

    /**
     * @Autowired 不仅可以放在任何方法上，还可放在属性上, 设置这个注解的属性表示spring会自动的尝试装配
     * 如果没有那么不会出错，否则会出现空指针异常
     * @param cd
     */
    @Autowired(required = false)
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void play()
    {
        System.out.println("cdplayer play");
        cd.play();
    }
}
