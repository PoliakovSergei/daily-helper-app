package ru.sergo.ecs.ecsback.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.CLASS
)
annotation class LogBefore(val value: String = "")

@Aspect
@Component
class LoggerAspect {

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @Before("@annotation(logBefore) || @within(logBefore)")
    fun loggingBeforeMethodExecution(joinPoint: JoinPoint, logBefore: LogBefore) {
        val logMsg = String.format(
            "Executing - %s%s",
            joinPoint.signature.toShortString(),
            if (logBefore.value.isBlank()) "" else " - " + logBefore.value
        )
        log.info(logMsg)
    }
}