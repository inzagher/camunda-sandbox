FROM maven:3.8.4-openjdk-8 as build
# Setup environment
ENV HOME=/home/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME

# Download dependencies
COPY pom.xml $HOME
RUN mvn dependency:resolve

# Build application
COPY . $HOME
RUN mvn clean package -Dmaven.test.skip

# Start application
FROM openjdk:8-alpine as deploy
WORKDIR /opt/inzagher-camunda-client
COPY --from=build /home/usr/app/target/inzagher-camunda-client-1.0.0.jar .
ENTRYPOINT ["java", "-jar", "inzagher-camunda-client-1.0.0.jar"]
