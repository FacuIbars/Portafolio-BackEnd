FROM openjdk:19-ea-jdk-slim

LABEL maintainer="FacuIbars"

COPY target/portafolio-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
