package com.springBoot.AopDemo.aspect;
import com.springBoot.AopDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {

    @Around("execution(* com.springBoot.AopDemo.Service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {

        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n======> Executing @Around on method: " + method);

        long begin = System.nanoTime();

        Object result = null;

        try{
            result = joinPoint.proceed();
        }catch(Exception e){
            System.out.println(e.getMessage());
            result="Major Accident But no worries , your private Aop helicopter is on the way ";
        }

        long end = System.nanoTime();

        long duration = end - begin;

        System.out.println("\n===> Duration: " + duration + " Nano Seconds ");

        return result;
    }

    @After("execution(* com.springBoot.AopDemo.Dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();

        System.out.println("after method: " + method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.springBoot.AopDemo.Dao.AccountDao.findAccounts(..))",
            throwing = "theExec"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExec){

        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("method: " + method);

    }


    @AfterReturning(
            pointcut = "execution(* com.springBoot.AopDemo.Dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("method: " + method);

        System.out.println("result: " + result);

        convertAccountNameToUppercase(result);

    }

    private void convertAccountNameToUppercase(List<Account> result) {

        for (Account account : result) {
            String theUpperName =  account.getName().toUpperCase();
            account.setName(theUpperName);
        }

    }

    @Before("com.springBoot.AopDemo.aspect.AopExpressions.forDaoNoGetterAndSetter()")
    public void beforeAddAccount(JoinPoint theJoinPoint) {

        System.out.println("before addAccount");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("methodSignature: " + methodSignature);

        Object[] args = theJoinPoint.getArgs();

        System.out.println("args: " + Arrays.toString(args));

    }

}
