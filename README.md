# EBF
EBF

Documentation
-------------
http://localhost:8181/swagger-ui.html

Design Considerations
----------------------
	Database
		 H2 Database with default username and password
	REST
		Spring Boot
  
DB Standard
------------
	SQL Defination and Naming Convention
	TABLE Name :  Small Case.
		Syantax: Employees
	Column Name : 
		Syantax: <tablename-prefix>_<column-name>
	Primary Key :  <tablename>_<primary key>_pk
	Foreign Key  : <tablename>_<foreign key>_fk

How to run project
------------------

Running as a packaged application
----------------------------------
If you use the Spring Boot Maven to create an executable jar you can run your application using java -jar. For example:

$ java -jar EBF-Employee-Management-1.0.1-SNAPSHOT.jar
It is also possible to run a packaged application with remote debugging support enabled. This allows you to attach a debugger to your packaged application:
Note: Default port is 8080.
 

Using the Maven plugin
-----------------------
The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run application.

$ mvn spring-boot:run


Note: To intitilize the Employees and Companies Data - Make Get request to http://localhost:8181/api/v1/init
