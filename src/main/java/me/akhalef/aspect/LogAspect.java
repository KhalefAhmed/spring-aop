package me.akhalef.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LogAspect {
    Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Around("@annotation(me.akhalef.aspect.Log)")
    public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        logger.info("LogAspect: Before process method " + joinPoint.getSignature());
        Object result = joinPoint.proceed();
        logger.info("LogAspect: After process method" + joinPoint.getSignature());
        long t2 = System.currentTimeMillis();
        logger.info("LogAspect: Execution time: " + (t2 - t1) + " ms");

        return result;
    }
}
