package com.epam.mentoring.lessone.classloader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Aleh_Atsman on 10/6/2014.
 */
public class SecureClassLoader extends ClassLoader {

    private String pathToJar;

    public SecureClassLoader(String pathToJar) {
        super(SecureClassLoader.class.getClassLoader());
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkCreateClassLoader();
        }

        this.pathToJar = pathToJar;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            return defineClass(pathToJar, name);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }

    private Class<?> defineClass(String jarPath, String name) throws IOException {
        File file = new File(jarPath);
        byte[] b = loadJarClassAsBytes(file, name);
        return defineClass(name, b, 0, b.length);
    }

    private static byte[] loadJarClassAsBytes(File file, String name) throws IOException {
        JarFile jarFile = new JarFile(file);
        String classFileName = name.replace('.', '/') + ".class";
        JarEntry jarEntry = jarFile.getJarEntry(classFileName);
        byte[] result = new byte[(int) jarEntry.getSize()];
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        try {
            inputStream.read(result, 0, result.length);
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
        return result;
    }
}
