# Stage 1: Build Stage
# Use a Maven image with JDK 21
FROM maven:3.9.4-eclipse-temurin-21 AS build
# Set working directory
WORKDIR /opt/demo
# Copy the pom.xml file
COPY pom.xml .
# Download dependencies
RUN mvn dependency:go-offline
# Copy the source code
COPY src ./src
# Package the application
RUN mvn clean install -DskipTests

# Stage 2: Runtime Stage
# Use Eclipse Temurin JRE 21
FROM eclipse-temurin:21-jre
# Set deployment directory
WORKDIR /opt/demo
# Copy the built jar file from the build stage
COPY --from=build /opt/demo/target/*.jar /opt/demo/demo.jar
# Command to run the application
CMD ["java", "-jar", "demo.jar"]
