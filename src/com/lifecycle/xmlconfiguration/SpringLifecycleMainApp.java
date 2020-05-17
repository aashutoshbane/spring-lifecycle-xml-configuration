/**
 * 
 */
package com.lifecycle.xmlconfiguration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ashutosh Bane
 *
 */
public class SpringLifecycleMainApp {

	public static void main(String[] args) {
		System.out.println("Before container initialization..,");
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationLifecycleContext.xml");
		
		ILaptop oldHpGeneration = context.getBean("myHpLaptop", ILaptop.class);
		
		System.out.println("\nBefore container destruction...");
		
		// close the context
		context.close();
	}

}
