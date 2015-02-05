package com.epam.mentoring.profiler;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by alehatsman on 12/28/14.
 */
@Component
@Aspect
public class TimeExecutionProfiler {

    private static final Logger logger = Logger.getLogger(TimeExecutionProfiler.class);

    @Around("com.epam.mentoring.profiler.SystemArchitecture.businessController()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        logger.info("ServicesProfiler.profile(): Going to call the method: " + pjp.getSignature().getName());
        Object output = pjp.proceed();
        logger.info("ServicesProfiler.profile(): Method execution completed.");
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("ServicesProfiler.profile(): Method execution time: " + elapsedTime + " milliseconds.");

        return output;
    }

    @After("com.epam.mentoring.profiler.SystemArchitecture.businessController()")
    public void profileMemory() {
        logger.info("JVM memory in use = " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }
}
