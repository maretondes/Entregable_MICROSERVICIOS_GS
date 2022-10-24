FROM openjdk:8-jdk-slim
COPY "./target/searchuser-0.0.1-SNAPSHOT.jar" "user.jar"
EXPOSE 7085
ENTRYPOINT ["java","-jar","user.jar"]