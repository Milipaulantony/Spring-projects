package com.springlearning.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
This spring pre-configured for logging, security, transactions, monitoring
Client
  ↓
Proxy
  ↓
LoggingAspect
  ↓
Actual Service Method

Here spring creates proxy object dynamically
 */

/*getsignature give method name called under service package,Before any service method runs: */

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.springlearning.demo.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("AOP LOG : "
                + joinPoint.getSignature().getName()
                + " method called");
    }
}
