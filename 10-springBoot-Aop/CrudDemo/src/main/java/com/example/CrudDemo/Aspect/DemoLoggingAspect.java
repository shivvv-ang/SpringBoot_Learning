package com.example.CrudDemo.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.CrudDemo.controller.*.*(..))")
    private void forControllerPackage(){

    }

    @Pointcut("execution(* com.example.CrudDemo.service.*.*(..))")
    private void forServicePackage(){

    }

    @Pointcut("execution(* com.example.CrudDemo.dao.*.*(..))")
    private void forDaoPackage(){

    }


    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint ThejoinPoint){

        String theMethod = ThejoinPoint.getSignature().toShortString();
        myLogger.info("===> in @Before : calling method : "+ theMethod);


        Object[] theArgs = ThejoinPoint.getArgs();

        for(Object arg : theArgs){
            myLogger.info("===> arg : "+ arg);
        }

    }

    @AfterReturning(pointcut = "forAppFlow()",returning = "result")
    public void afterReturning(JoinPoint ThejoinPoint, Object result){

        String theMethod = ThejoinPoint.getSignature().toShortString();
        myLogger.info("===> in @AfterReturning : from method : "+ theMethod);

        myLogger.info("===> result : "+result);

    }

}
