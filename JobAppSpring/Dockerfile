FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN ./mvnw clean package

EXPOSE 8080

CMD ["java", "-jar", "target/JobAppSpring-0.0.1-SNAPSHOT.jar"]
