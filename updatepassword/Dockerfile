FROM openjdk:8-jdk-slim
COPY "./target/updatepassword-0.0.1-SNAPSHOT.jar" "updatepassword.jar"
EXPOSE 7084
ENTRYPOINT ["java","-jar","updatepassword.jar"]