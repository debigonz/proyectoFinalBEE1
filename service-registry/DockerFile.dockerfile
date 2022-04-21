FROM adoptopenjdk/openjdk17:alpine-jre
ARG JAR_FILE=./target/service-registry-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8761