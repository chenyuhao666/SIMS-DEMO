package com.demo.student.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect2 {

    @Pointcut("@annotation(com.demo.student.config.aop.LogPrinter)")
    public void log2(){

    }

    @Before("log2()")
    public void doBefore(JoinPoint joinPoint){
    System.out.println(joinPoint.getSignature().getName() + "执行前" + System.currentTimeMillis());
    }

     @After("log2()")
     public void doAfter(JoinPoint joinPoint){
     System.out.println(joinPoint.getSignature().getName() + "执行后" + System.currentTimeMillis());
     }

}
