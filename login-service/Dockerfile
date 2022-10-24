FROM openjdk:8-jdk-slim
COPY "./target/login-service-0.0.1-SNAPSHOT.jar" "login.jar"
EXPOSE 7081
ENTRYPOINT ["java","-jar","login.jar"]