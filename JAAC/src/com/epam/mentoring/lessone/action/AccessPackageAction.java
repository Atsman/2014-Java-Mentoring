package com.epam.mentoring.lessone.action;

import com.epam.mentoring.lessone.classloader.SecureClassLoader;

import java.security.PrivilegedAction;

public class AccessPackageAction implements PrivilegedAction {

	/**
	 * Relative path to the jar file. Current directory "./" is a project root
	 * directory.
	 */
	public static final String JAR_PATH = "./Semaphore.jar";
	
	private static final String CLASS_NAME = "com.epam.mentoring.lessone.semaphore.Semaphore";
	
	@Override
	public Object run() {
		try {
			SecureClassLoader scl = new SecureClassLoader(JAR_PATH);
			Class<?> semaphore = scl.loadClass(CLASS_NAME);

            SemaphoreProxy semaphoreProxy = new SemaphoreProxy(semaphore);
            semaphoreProxy.lever();

			System.out.println("Class load: success!");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
}
