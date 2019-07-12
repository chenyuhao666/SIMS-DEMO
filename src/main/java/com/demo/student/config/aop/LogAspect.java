package com.demo.student.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/12 14:20
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * com.demo.student.service.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "执行前");
    }

    @After("log()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "执行后");
    }

}
