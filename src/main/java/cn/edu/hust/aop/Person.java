package cn.edu.hust.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 *
 * @Aspect注解表示将这个bean声明为一个切面
 */
@Component
@Aspect
public class Person {
    /**
     * @Pointcut注解表示切点，表示在哪里执行通知
     * 下面这个方法并不是非必需的，只是为了减少下面的通知方法的匹配
     */
    @Pointcut("execution(* cn.edu.hust.aop.*.watch(..))")
    public void watch(){}

    /**
     * @Before注解是前置通知，在目标方法之前执行
     */
    @Before("watch()")
    public void call()
    {
        System.out.println("person call phone for ticket");
    }

    @Before("watch()")
    public void selectSeat()
    {
        System.out.println("person need select seats");
    }

    /**
     * @After注解表示后置通知，目标方法执行之后在执行通知
     */
    @After("watch()")
    public void hclap()
    {
        System.out.println("the person clap");
    }

    /**
     * @AfterThrowing表示出现异常以后执行该通知
     */
    @AfterThrowing("watch()")
    public void refund()
    {
        System.out.println("person need refund");
    }

    /**
     * @AfterReturning注解表示方法返回之后执行该通知，
     */
    @AfterReturning("watch()")
    public void back()
    {
        System.out.println("the moive end,the person is back");
    }

    /**
     * 环绕通知，这里通知的效果结合了所有通知的类型
     * @param proceedingJoinPoint
     * 参数是必须要有的，当通知被执行后才将控制权给这个参数执行目标方法
     * 这里需要注意的是必须调用这个方法proceed()否则后阻塞被通知方法的调用。
     */
    @Around("watch()")
    public void full(ProceedingJoinPoint proceedingJoinPoint)
    {
        try
        {
            System.out.println("person call phone for ticket");
            System.out.println("person need select seats");
            //int a=1/0;
            proceedingJoinPoint.proceed();
            System.out.println("the moive end,the person is back");
        }
        catch (Throwable e)
        {
            System.out.println("person need refund");
        }
        finally {
            System.out.println("the person clap");
        }

    }

}
