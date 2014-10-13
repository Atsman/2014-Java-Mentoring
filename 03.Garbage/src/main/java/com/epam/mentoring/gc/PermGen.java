package com.epam.mentoring.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alehatsman on 10/11/14.
 */
class PermGen {

    private static final String CLASS_NAME = "com.epam.mentoring.lessone.semaphore.Semaphore";
    private static final String JAR_PATH = "./Semaphore.jar";

    public static void main(String[] args) throws ClassNotFoundException {
        List<ClassLoader> l = new ArrayList<>();

        while(true) {
            ClassLoader cl = new MyClassLoader(JAR_PATH);
            l.add(cl);
            cl.loadClass(CLASS_NAME);
        }
    }

}
