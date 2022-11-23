# springboot-CRUD
Spring boot CRUD (Create, Read, Update, Delete) demo application with MySQL db.

## Prerequisites 
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [MySQL](https://www.mysql.com/)

## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)
- MySQL Workbench (for monitoring stored data)

## Setup DB
- Download MySQL workbench and create a databse
> **```create database students```** it will create a db locally
- Then
> **```use students```**  this will start using db students

###  Build and Run application
_GOTO >_ **~/absolute-path-to-directory/springboot-CRUD**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-springboot-CRUD/target/springboot-CRUD-0.0.1-SNAPSHOT.jar```**

Or
> run main method from `SpringBootCrudApplication.java` as spring boot application.
