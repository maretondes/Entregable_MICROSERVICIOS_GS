FROM openjdk:8-jdk-slim
COPY "./target/api-gateway-0.0.1-SNAPSHOT.jar" "gateway.jar"
EXPOSE 7086
ENTRYPOINT ["java","-jar","gateway.jar"]