FROM openjdk:17-jdk-slim
COPY target/ConsoleDatabaseManager-1.0-SNAPSHOT.jar /app/app.jar
WORKDIR /app
CMD ["java", "-jar", "/app/target/ConsoleDatabaseManager-1.0-SNAPSHOT.jar"]

