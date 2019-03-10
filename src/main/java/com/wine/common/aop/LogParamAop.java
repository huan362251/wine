package com.wine.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 入参、出参aop切面
 */
@Aspect
public class LogParamAop {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //拦截controller下的所有方法
    @Pointcut("execution(* com.wine.project..controller..*.*(..))")
    private void controllerMethod(){}

    @Around("controllerMethod()")
    public Object doAround(ProceedingJoinPoint point){

        String message = "aop[" + point.getSignature().getDeclaringTypeName() + "]";

        return new Object();
    }
}
