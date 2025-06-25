#!/usr/bin/env bash

# Install Java 17 (Render default path)
export JAVA_HOME=/opt/render/project/java17
export PATH=$JAVA_HOME/bin:$PATH

# Run Maven build
./mvnw clean package
