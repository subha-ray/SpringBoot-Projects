#!/usr/bin/env bash

# Download and install Java 17 (Render doesn't provide it by default anymore)
curl -s "https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz" -o java.tar.gz
mkdir -p java
tar -xzf java.tar.gz -C java --strip-components=1
export JAVA_HOME=$PWD/java
export PATH=$JAVA_HOME/bin:$PATH

# Verify Java is available
java -version

# Now run Maven build
./mvnw clean package
