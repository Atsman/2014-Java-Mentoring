package com.epam.mentoring.lessone.classloader;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by alehatsman on 10/4/14.
 */
public class SecureURLClassLoader extends URLClassLoader {
    
    public SecureURLClassLoader(URL urls) {
        super(new URL[] {urls}, SecureURLClassLoader.class.getClassLoader());
    }
    
}
