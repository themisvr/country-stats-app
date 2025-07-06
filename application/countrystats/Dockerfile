FROM maven:3.9.10-amazoncorretto-21-al2023 AS build

WORKDIR /app

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]