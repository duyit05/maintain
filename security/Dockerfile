# Stage 1 : build
# Start with a maven igame that includes JDK 17
FROM maven:3.9.9-amazoncorretto-17 AS build

# Copy source code and pom.xml file to / app folder
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build source code with maven
RUN mvn package -DskipTests

# run command
# 1 : docker build -t review-security-exception:0.0.1 .
# 2 :docker run --name security  -p 8080:8080 -e DBMS_CONNECTION=jdbc:mysql://172.17.0.2:3306/review_security_exception review-security-exception:0.0.1



# Stage 2 : create imgage
# Start with amazon correto JDK 17
FROM amazoncorretto:17.0.12

# Set working folder to app and coppy complied file from above step
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Command to run the application
ENTRYPOINT ["java" , "-jar" , "app.jar"]