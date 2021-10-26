package ru.appTesting.spring.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* ru.appTesting.spring.service.TestServiceImpl.runTest(..))")
    public void logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("_________Тест начался_________");
        joinPoint.proceed();
        System.out.println("______________________________");
        System.out.println("______________________________");
        System.out.println("______________________________");
    }
}

