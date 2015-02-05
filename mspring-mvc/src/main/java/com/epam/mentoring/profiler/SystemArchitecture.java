package com.epam.mentoring.profiler;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by alehatsman on 12/28/14.
 */
@Component
@Aspect
public class SystemArchitecture {

    @Pointcut("execution(* com.epam.mentoring.controllers..*.*(..))")
    public void businessController() {
    }
}
