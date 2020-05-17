# spring-lifecycle-xml-configuration
Basic spring lifecycle de-tour

### Spring Bean Scopes
1. singleton: Creates the single shared instance of a bean. Default scope.
2. prototype: Creates the new bean instance for each container request.
3. request: Scoped to an HTTP web request. Only used for web apps.
4. session: Scoped to an HTTP web session. Only used for web apps.
5. global-session: Scoped to an global HTTP web session. Only used for web apps.

### Bean Lifecycle Methods/Hooks
* You can add custom code during bean initialization
  * Calling custom business logic methods
  * Setting up handles to resources (sockets, db, file etc)
  
* You can add custom code during bean destruction
  * Calling custom business logic methods
  * Setting up handles to resources (sockets, db, file etc)
  
#### Special Note about init and destroy Method Signatures
When using XML configuration,

* **Access modifier**
The method can have any access modifier (public, protected, private)

* **Return type**
The method can have any return type. However, "void' is most commonly used. If you give a return type just note that you will not be able to capture the return value. As a result, "void" is commonly used.

* **Method name**
The method can have any method name.

* **Arguments**
The method can not accept any arguments. The method should be no-arg.

There is a subtle point you need to be aware of with "prototype" scoped beans.
For "prototype" scoped beans, Spring does not call the destroy method.  Gasp! 

**QUESTION**: How can I create code to call the destroy method on prototype scope beans <br/>
**ANSWER**: You can destroy prototype beans but custom coding is required.<br/>

1. Create a custom bean processor. This bean processor will keep track of prototype scoped beans. During shutdown it will call the destroy() method on the prototype scoped beans. The custom processor is configured in the spring config file.
```<!-- Bean custom processor to handle calling destroy methods on prototype scoped beans -->
        <bean id="customProcessor"
    		class="com.lifecycle.xmlconfiguration.CustomBeanProcessor">
   	</bean>
```

2. The prototype scoped beans _MUST_ implement the DisposableBean interface. This interface defines a "destory()" method.
```
public class HpLaptop implements ILaptop, DisposableBean {
 
	...
	
	// add a destroy method
	@Override
	public void destroy() throws Exception {
		System.out.println("Machine shutting down...");		
	}
}
```

3. The spring configuration must be updated to use the destroy-method of "destroy".
```
<bean id="myHpLaptop"
	class="com.lifecycle.xmlconfiguration.LaptopService"
 	init-method="initStuff"
 	destroy-method="destroy"
 	scope="prototype">	
	
 	<!-- setup setter injection -->
	<property name="laptopService" ref="theLaptopService"></property>
</bean>
```

# Dependency for running the application


### Download spring jar files
https://repo.spring.io/release/org/springframework/spring/
1. Choose the latest stable release "*-dist.zip".
2. Copy all the jar files under lib folder from the downloaded zip.
3. Create a new folder name lib under your working directory.
4. Paste those jar files under lib folder.
5. Add classpath to your eclipse project.
6. Right click on your "Project" >> "Properties" >> "Java Build Path" >> "Libraries" tab >> Click "Add JARs" >> "Select all the JAR files from you lib folder" >> "Apply and Close".
7. Now there will be a "Referenced Libraries" folder which will have your all spring JAR files.
8. Done

### Run Project
Right click on your project >> Run As >> Java Application
