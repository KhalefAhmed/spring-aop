package me.akhalef.aspect;

import me.akhalef.service.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorizationAspect {

    @Around(value = "@annotation(me.akhalef.aspect.SecuredByAspect)",
            argNames = "joinPoint,securedByAspect")
    public Object authorize(ProceedingJoinPoint joinPoint, SecuredByAspect securedByAspect) throws Throwable {

        String[] roles = securedByAspect.roles();
        boolean authorized = false;
        for (String role : roles) {
            if (SecurityContext.hasRole(role)) {
                authorized = true;
                break;
            }
        }

        if (authorized) {
            return joinPoint.proceed();
        }

        throw new SecurityException("User " + SecurityContext.username + " is not authorized to access this method");
    }

}
