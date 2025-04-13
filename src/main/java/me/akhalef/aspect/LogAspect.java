package me.akhalef.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LogAspect {
    @Before("execution(* me.akhalef.service.*.*(..))")
    public void logBefore() {
        System.out.println("LogAspect: Before process method");
    }
}
