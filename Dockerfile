FROM openjdk:8
ADD target/employee-service.jar employee-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar", "employee-service.jar"]