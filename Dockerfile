# Starting with this Linux server
FROM maven:3-eclipse-temurin-21

## Build the application
# Create a directory call /app
# go into the directory cd /app
WORKDIR /app

# everything after this is in /app
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

# Build the application
RUN mvn package -Dmaven.test.skip=true

## Run the application
# Define environment variable 
ENV SERVER_PORT=8080 
# ENV SPRING_REDIS_HOST=localhost SPRING_REDIS_PORT=6379
# ENV SPRING_REDIS_USERNAME=NOT_SET SPRING_REDIS_PASSWORD=NOT_SET

# Expose the port
EXPOSE ${SERVER_PORT}

# Run the program
ENTRYPOINT SERVER_PORT=${PORT} java -jar target/capstone-0.0.1-SNAPSHOT.jar