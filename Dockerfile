# Stage 1: Build the JAR file
FROM gradle:8.5.0-jdk21 AS builder
WORKDIR /app
COPY . .
RUN gradle clean build

# Stage 2: Package the JAR into a Docker image
FROM amazoncorretto:21.0.2-alpine3.19 AS runtime
WORKDIR /app
COPY --from=builder /app/build/libs/k8s-spring-poc-0.0.1.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
