Spring Boot Example Project
===================

This is a sample Java / Maven / Spring Boot / AngularJs application which includes following features.

 - Spring Boot Web App
 - Rest Controller / Rest Api
 - Spring Data JPA
 - Spring Security
 - Swagger: API documentation 
 - AngularJs: Controller, Factory , Custom Directive 

How to run
-------------
 - Clone the repository
 - Make sure you are using JDK 1.7 and Maven 
 - Import in Eclipse as a maven project or any in IDE you are using 
 - Update Application.properties file with following details 
	 - `spring.datasource.url`
	 - `spring.datasource.username`
	 - `spring.datasource.password`
 - Goto DemoApplication.java and run Application: This will start the application and create required table in database.
 - Now Run the following query to insert a user record in user table 
	 - `insert into app_user values (1,'demo@test.com','demo','$2a$10$gTfVNWohN7tA3zBaRL9amueJ7.OkgXttFsD5xJKpgq.S4SDomc7IO')`
 - Application will run on default 8080 port and can be accessed from localhost:8080, this will show default i.e login page. 
 - Enter `demo@test.com`as username and `admin` as password 
 - To find API documentation visit http://localhost:8080/swagger-ui.html

About Application 
-------------------------
This is simple web application having one form for all crude operations. Spring Boot is used for rest api creation and Angularjs has been used to interact with API from client side. It is using relational database. You just need to create database and update application.properties file. 

Here is what this little application demonstrates:

 - Full integration with the latest Spring Boot Framework: inversion of control, dependency injection etc.
 - Spring Data  JPA Integration with with just a few lines of configuration and familiar annotations.
 - Writing a RESTful service using annotation.
 - All APIs are "self-documented" by Swagger. 
 - Spring Security integration.
 - AngularJs  integration with [John Papa](https://github.com/johnpapa/angular-styleguide) angular style guide for client side : controller, Data Factory , Custom directive, Validations, Form etc 

Questions and Comments: [atinder.singh67@gmail.com](atinder.singh67@gmail.coom)
---------------

