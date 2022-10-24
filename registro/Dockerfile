FROM openjdk:8-jdk-slim
COPY "./target/registro-0.0.1-SNAPSHOT.jar" "registro.jar"
EXPOSE 7082
ENTRYPOINT ["java","-jar","registro.jar"]