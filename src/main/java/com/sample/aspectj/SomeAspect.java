package com.sample.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by elvis on 12/27/16.
 */
@Aspect
@Component
public class SomeAspect {

    // Reusable Pointcut definition
    @Pointcut("execution(* com.sample.aspectj.SomeService.someMethod(..)) && args(someValue,..)")
    private void someMethodPointcut(String someValue){};

    // Advice with implicit pointcut
    @Before("execution(* com.sample.aspectj.SomeService.someMethod(..)) && args(someValue,..)")
    public void beforeSomeMethod(JoinPoint joinPoint, String someValue) {
        System.out.println("Starting: " + joinPoint + " with value: " + someValue);
    }

    // Advice with pointcut reference
    @AfterReturning("someMethodPointcut(someValue)")
    public void afterSomeMethodReturns(JoinPoint joinPoint, String someValue) {
        System.out.println("Completed: " + joinPoint + " with value: " + someValue);
    }

    @Around("someMethodPointcut(someValue)")
    public void aroundSomeMethod(ProceedingJoinPoint pjp, String someValue) throws Throwable{
        System.out.println("Around 1: " + pjp + " with value: " + someValue);
        pjp.proceed();
        System.out.println("Around 2: " + pjp + " with value: " + someValue);
    }

}
