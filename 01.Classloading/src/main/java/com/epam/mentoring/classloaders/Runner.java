package com.epam.mentoring.classloaders;

import org.apache.log4j.Logger;

/**
 * Created by Aleh_Atsman on 10/2/2014.
 */
public class Runner {

    private static final Logger LOGGER = Logger.getLogger(Runner.class);

    public static void main(String[] args) {
        final String classname = args[0];
        final String workingDir = System.getProperty("user.dir");
        LOGGER.info("Current working dir = " + workingDir);
        MyClassLoader myClassLoader = new MyClassLoader(workingDir);
        try {
            LOGGER.info("Loading class " + classname);
            Class<?> loadedClass = myClassLoader.loadClass(classname);
            SemaphoreProxy semaphoreProxy = new SemaphoreProxy(loadedClass);
            LOGGER.info("Invoke method lever");
            semaphoreProxy.lever();
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
