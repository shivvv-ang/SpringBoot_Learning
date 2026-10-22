package com.springBoot.AopDemo.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {

    @Before("com.springBoot.AopDemo.aspect.AopExpressions.forDaoNoGetterAndSetter()")
    public void beforeAddAccount() {
        System.out.println("before addAccount");
    }

}
