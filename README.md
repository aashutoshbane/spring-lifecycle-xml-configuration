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
