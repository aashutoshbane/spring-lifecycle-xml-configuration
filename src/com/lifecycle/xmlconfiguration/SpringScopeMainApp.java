package com.lifecycle.xmlconfiguration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lifecycle.xmlconfiguration.ILaptop;

/**
 * @author Ashutosh Bane
 *
 */
public class SpringScopeMainApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationScopeContext.xml");

		// singleton scope
		ILaptop oldHpGeneration = context.getBean("myHpLaptop", ILaptop.class);
		ILaptop newHpGeneration = context.getBean("myHpLaptop", ILaptop.class);

		boolean hpResult = (oldHpGeneration == newHpGeneration);
		System.out.println("Object comparison of singleton scope bean");
		System.out.println("Pointing to same object: " + hpResult);
		System.out.println("Memory location of oldHpGeneration: " + oldHpGeneration);
		System.out.println("Memory location of newHpGeneration: " + newHpGeneration + "\n");

		// prototype scope
		ILaptop oldDellGeneration = context.getBean("myDellLaptop", ILaptop.class);
		ILaptop newDellGeneration = context.getBean("myDellLaptop", ILaptop.class);

		boolean dellResult = (oldDellGeneration == newDellGeneration);
		System.out.println("Object comparison of prototype scope bean");
		System.out.println("Pointing to same object: " + dellResult);
		System.out.println("Memory location of oldDellGeneration: " + oldDellGeneration);
		System.out.println("Memory location of newDellGeneration: " + newDellGeneration);

		// close the context
		context.close();
	}

}
