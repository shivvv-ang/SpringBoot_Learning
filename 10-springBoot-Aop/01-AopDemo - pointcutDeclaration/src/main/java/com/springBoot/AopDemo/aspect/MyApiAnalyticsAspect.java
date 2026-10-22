package com.springBoot.AopDemo.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.springBoot.AopDemo.aspect.AopExpressions.forDaoNoGetterAndSetter()")
    public void performApiAnalytics(){
        System.out.println("performApiAnalytics");
    }

}
