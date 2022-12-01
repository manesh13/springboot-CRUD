FROM openjdk:8

COPY target/springboot-crud-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar","/app.jar"]