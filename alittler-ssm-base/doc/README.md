说明：
	Tomcat 8	Java 1.8
	访问首页：http://127.0.0.1:8080/alittler-ssm-base/
	测试页面：http://127.0.0.1:8080/alittler-ssm-base/mytest/index.do
	列表页面：http://127.0.0.1:8080/alittler-ssm-base/person/listPerson.do
	
web.xml配置文件中的webAppRootKey作用
	<context-param>
	   	<param-name>webAppRootKey</param-name>
	   	<param-value>sociality.root</param-value>
 	</context-param>
 在web.xml文件中要配置上述节点，如果不配置的话，webAppRootKey的值默认值为webapp.root，指向当前发布的工程。 
如果在一个tomcat中部署多个项目，项目是串行启动的，如果使用默认值的话，webAppRootKey已经指向之前已启动的项目，而不是指向当前工程，就会出现启动不了的问题。
解决办法： 
每个工程都显示配置这个属性，并且webAppRootKey的值都不一样，最好用”工程名.root”来表示。
 	
	