package com.example.price.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopLogger {

    /*@Pointcut (" execution( * com.example.price.service.impl.priceInfoServImpl.*(..) ) " )
    public void ServiceMethod(){

    }*/

    //@Around(" execution( * com.example.price.service.impl.priceInfoServImpl.*(..) ) " )
    @Around("@annotation(LogExecutionTime)")
    public Object AroundLog(ProceedingJoinPoint
                                        proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();
         Object proceed = proceedingJoinPoint.proceed();
        long duration  = System.currentTimeMillis() - start ;

        System.out.println(proceedingJoinPoint.getSignature() + "execution time " + duration + " ms" );
        return proceed;
    }



}
