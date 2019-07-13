package com.demo.student.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: chenyuhao
 * @Date: 2019/7/12 14:20
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * com.demo.student.service.*.log*(..))")
    public void log(){

    }

   /** @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "执行前" + System.currentTimeMillis());
    }

    @After("log()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "执行后" + System.currentTimeMillis());
    }**/

    @Around("log()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        return point.proceed();
    }

}
