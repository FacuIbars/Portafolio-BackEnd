FROM amazoncorretto:17-alpine-jdk
MAINTAINER FacuIbars
COPY target/Portafolio-0.0.1-SNAPSHOT.jar portafolio-app.jar
ENTRYPOINT ["java", "-jar", "/portafolio-app.jar"]