package com.imooc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Shinelon
 */
//@Aspect
//@Component
public class TimeAspect {

    @Around("execution(* com.imooc.web.rest.UserController.*(..))")
    public Object handlerController(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("TimeAspect start");
        long start = System.currentTimeMillis();
//        try {
            Object result = pjp.proceed();
//        }catch (Exception e){
//            System.out.println(e);
//            throw e;
//        }
        System.out.println("TimeAspect end");
        System.out.println("耗时:" + (System.currentTimeMillis() - start));

        return result;
    }
}
