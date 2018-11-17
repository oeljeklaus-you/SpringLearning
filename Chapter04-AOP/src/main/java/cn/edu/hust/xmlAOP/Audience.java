package cn.edu.hust.xmlAOP;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {

    public void turnOffCellPhone()
    {
        System.out.println("turn off cell phone");
    }

    public void takeSeats()
    {
        System.out.println("taking seats");
    }

    public void applause()
    {
        System.out.println("Clap Clap Clap!");
    }

    public void demandRefund()
    {
        System.out.println("demand a refund");
    }

    public void watchPerformance(ProceedingJoinPoint joinPoint)
    {
        try
        {
            System.out.println("turn off cell phone");
            System.out.println("taking seats");
            joinPoint.proceed();
            System.out.println("Clap Clap Clap!");
        } catch (Throwable throwable) {
            System.out.println("demand a refund");
        }


    }


}
