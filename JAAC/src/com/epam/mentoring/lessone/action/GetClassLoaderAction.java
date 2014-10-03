package com.epam.mentoring.lessone.action;

import java.net.URL;
import java.net.URLClassLoader;
import java.security.PrivilegedAction;

public class GetClassLoaderAction implements PrivilegedAction<ClassLoader> {

	@Override
	public ClassLoader run() {
		ClassLoader cl = new URLClassLoader(new URL[]{});
		return cl;
	}

}
