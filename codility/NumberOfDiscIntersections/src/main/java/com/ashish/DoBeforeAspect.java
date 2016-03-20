package com.ashish;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author Ashish Sharma
 *         Created on 6/28/2015.
 */
@Aspect
public class DoBeforeAspect {
    @Before("execution(* SimpleService.sayHello(..))")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("***AspectJ*** DoBefore() is running!! intercepted : " + joinPoint.getSignature().getName());
    }
}