package com.springBoot.AopDemo.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

    @Before("execution(* com.springBoot.AopDemo.Dao.*.*(..))")
    public void beforeAddAccount() {
        System.out.println("before addAccount");
    }

}
