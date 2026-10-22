package com.springBoot.AopDemo.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.springBoot.AopDemo.aspect.AopExpressions.forDaoNoGetterAndSetter()")
    public void logToCloudAsync(){
        System.out.println("LoggingToCloudAsync");
    }

}
