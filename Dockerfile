# Step 1 – Build jar inside Docker using Maven
FROM maven:3.9.6-eclipse-temurin-22 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2 – Run the jar using JDK image
FROM eclipse-temurin:22-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]