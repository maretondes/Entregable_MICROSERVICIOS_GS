FROM openjdk:8-jdk-slim
COPY "./target/monitoreo-0.0.1-SNAPSHOT.jar" "monitoreo.jar"
EXPOSE 7087
ENTRYPOINT ["java","-jar","monitoreo.jar"]