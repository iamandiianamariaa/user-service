FROM openjdk:11
COPY ./target/user-service-1.0-SNAPSHOT.jar user-service.jar
CMD ["java", "-jar", "user-service.jar"]