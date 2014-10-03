package com.epam.mentoring.lessone.action;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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
		File file = new File(JAR_PATH);
		URL jarUrl;
		try {
			jarUrl = file.toURI().toURL();
			
			//TODO: implement class loader
			//SecureURLClassloader scl = new SecureURLClassloader(jarUrl);
			//scl.getClass(CLASS_NAME);
			
			
			System.out.println("Class load: success!");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

}
