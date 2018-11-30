package cn.edu.hust.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EncorableIntroduce {
    /**
     * @DeclareParents注解将Encorable接口注入到MoiveWatchbean中呢，注解所标注的静态属性指明了要引入了接口
     * value属性指定那种类型的bean要引入接口
     * defaultImpl属性指定为引入功能提供实现的类
     */
    @DeclareParents(value="cn.edu.hust.aop.MoiveWatch",defaultImpl = cn.edu.hust.aop.EncodeImpl.class)
    private static Encorable encorable;
}
