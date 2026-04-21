FROM eclipse-temurin:25-jdk-noble
WORKDIR /app
COPY Bus-System.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]