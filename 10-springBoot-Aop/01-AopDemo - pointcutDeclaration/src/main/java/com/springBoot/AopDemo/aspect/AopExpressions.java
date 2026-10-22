package com.springBoot.AopDemo.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.springBoot.AopDemo.Dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.springBoot.AopDemo.Dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.springBoot.AopDemo.Dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && ! ( getter() ||  setter() )")
    public void forDaoNoGetterAndSetter(){}

}
