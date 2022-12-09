# springboot-CRUD
Spring boot CRUD (Create, Read, Update, Delete) demo application with MySQL db.

## Prerequisites 
- [Java](https://www.w3schools.com/java/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [MySQL](https://www.mysql.com/)

## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)
- MySQL Workbench (for monitoring stored data)
- Docker (if you want to run project using docker)

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

## Run use Docker
- Download Docker from [Docker Website](https://www.docker.com/products/docker-desktop/)

_`Step 1`_ 
Pull Mysql image from docker hub
>`docker pull mysql:5.7`

_`Step 2`_
Create a docker network to communicate Spring Boot app with Mysql database
>`docker network create springboot-mysql-net` 

_`Step 3`_ Run the mysql container in the network
>`docker run --name mysqldb --network springboot-mysql-net -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=students -e MYSQL_USER=sa -e MYSQL_
PASSWORD=1234 -d mysql:5.7`

_`Step 4`_ Check the created database
>`docker exec -it` container-id `bash`

>`mysql -usa -p1234`
 
>`show databases`

_`Step 5`_ Update the application.yml file
>Replace line 4 `url: jdbc:mysql://localhost:3306/students` with 
> 
> `url: jdbc:mysql://mysqldb:3306/students`

>Comment line 5 and 6
> 
> Uncomment line 7 and 8

_`step 6`_ Build the springboot docker image
>`docker build -t springbootmysql .`


