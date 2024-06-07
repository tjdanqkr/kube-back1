FROM openjdk:23-ea-17-slim
LABEL authors="qkrtjdan"
COPY build/libs/*.jar app.jar
ARG profiles="prod"
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${profiles}","/app.jar"]
