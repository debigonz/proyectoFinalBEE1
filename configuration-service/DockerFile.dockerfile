FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=./target/configuration-service-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8888