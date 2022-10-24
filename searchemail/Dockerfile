FROM openjdk:8-jdk-slim
COPY "./target/searchemail-0.0.1-SNAPSHOT.jar" "email.jar"
EXPOSE 7083
ENTRYPOINT ["java","-jar","email.jar"]