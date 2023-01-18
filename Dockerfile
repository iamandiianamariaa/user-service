FROM openjdk:11-jre-slim
COPY ./target/user-service-1.0-SNAPSHOT.jar user-service.jar
CMD ["java", "-Xmx256M", "-jar", "user-service.jar"]