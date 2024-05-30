FROM openjdk:23-ea-17-slim
LABEL authors="qkrtjdan"
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]
