#!/usr/bin/env bash

# Download and install Java 17 (Adoptium)
curl -L https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.11+9/OpenJDK17U-jdk_x64_linux_hotspot_17.0.11_9.tar.gz -o java.tar.gz

mkdir -p java
tar -xzf java.tar.gz -C java --strip-components=1
export JAVA_HOME=$PWD/java
export PATH=$JAVA_HOME/bin:$PATH

# Run the built Spring Boot app
java -jar target/*.jar
