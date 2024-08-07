# Use the official OpenJDK 22 image
FROM openjdk:22-jdk

# Set the working directory
WORKDIR /app

# Copy the application JAR file to the container
COPY target/orderservice-0.0.1-SNAPSHOT.jar orderservice.jar

# Expose the application port
EXPOSE 8083

# Run the JAR file
ENTRYPOINT ["java", "-jar", "orderservice.jar"]
