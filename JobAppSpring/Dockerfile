FROM eclipse-temurin:17-jdk

# Set work directory
WORKDIR /app

# Copy everything
COPY . .

# Build the app
RUN ./mvnw clean package

# Expose port
EXPOSE 8080

# Run the WAR file
CMD ["java", "-cp", "target/JobAppSpring.war", "org.springframework.boot.loader.WarLauncher"]
