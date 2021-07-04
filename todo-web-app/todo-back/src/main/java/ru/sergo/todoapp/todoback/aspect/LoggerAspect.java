package ru.sergo.todoapp.todoback.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.TYPE})
    public @interface LogBefore {
        String value() default "";
    }

    @Before("@annotation(logBefore) || @within(logBefore)")
    public void loggingBeforeMethodExecution(JoinPoint joinPoint, LogBefore logBefore) {
        String logMsg = String.format("Executing - %s%s",
                joinPoint.getSignature().toShortString(),
                logBefore.value().isBlank() ? "" : " - " + logBefore.value());
        log.info(logMsg);
    }

//    @Before("execution(public * *(..)) && @target(logBefore)")
//    public void loggingBeforeClassMethodExecution(JoinPoint joinPoint, LogBefore logBefore) {
//        //loggingBeforeMethodExecution(joinPoint, logBefore);
//        log.info("All ok!");
//    }


}
