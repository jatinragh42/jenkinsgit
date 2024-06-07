# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the host to the container
COPY target/springboottest-0.0.1-SNAPSHOT.jar /app/springboottest-0.0.1-SNAPSHOT.jar

# Expose the port that the Spring Boot application runs on
EXPOSE 8084

# Run the JAR file with the correct port configuration
ENTRYPOINT ["java", "-jar", "/app/springboottest-0.0.1-SNAPSHOT.jar"]
