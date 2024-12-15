FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./target/atividade1-0.0.1-SNAPSHOT.jar /app/atividade1.jar
CMD ["java", "-jar", "atividade1.jar"]