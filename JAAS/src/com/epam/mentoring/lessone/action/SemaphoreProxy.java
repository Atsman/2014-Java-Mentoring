package com.epam.mentoring.lessone.action;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by alehatsman on 10/4/14.
 */
public class SemaphoreProxy {

    private final Class<?> semaphoreClass;
    private final Object semaphore;

    public SemaphoreProxy(final Class<?> semaphoreClass) throws InstantiationException, IllegalAccessException {
        this.semaphoreClass = semaphoreClass;
        Object object = semaphoreClass.newInstance();
        this.semaphore = object;
    }

    public void lever() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        final String lever = "lever";
        semaphoreClass.getMethod(lever, null).invoke(semaphore);
    }

}
