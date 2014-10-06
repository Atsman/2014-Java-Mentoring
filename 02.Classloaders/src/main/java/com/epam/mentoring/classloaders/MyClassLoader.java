package com.epam.mentoring.classloaders;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Aleh_Atsman on 10/2/2014.
 */
public class MyClassLoader extends ClassLoader {

    private static final Logger LOGGER = Logger.getLogger(MyClassLoader.class);

    private String currentRoot;

    public MyClassLoader(String currentRoot){
        super(MyClassLoader.class.getClassLoader());
        this.currentRoot = currentRoot;
    }

    private byte[] findClassBytes(final String className){
        try {
            String pathName = buildPath(className);
            FileInputStream inFile = new FileInputStream(pathName);
            byte[] classBytes = new byte[inFile.available()];
            inFile.read(classBytes);
            return classBytes;
        }
        catch (java.io.IOException e) {
            return null;
        }
    }

    private String buildPath(final String className) {
        return currentRoot + File.separatorChar + getFilename(className);
    }

    private String getFilename(final String className) {
        int lastIndexOfDot = className.lastIndexOf('.');
        String filename = className.substring(lastIndexOfDot + 1);
        return filename + ".class";
    }

    @Override
    protected Class<?> findClass(final String name)throws ClassNotFoundException {
        byte[] classBytes = findClassBytes(name);
        if (classBytes==null){
            throw new ClassNotFoundException();
        }
        else{
            return defineClass(name, classBytes, 0, classBytes.length);
        }
    }
}
