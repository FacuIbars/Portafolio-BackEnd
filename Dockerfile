FROM amazoncorretto:19
MAINTAINER FacuIbars
COPY target/portafolio-0.0.1-SNAPSHOT.jar portafolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/portafolio-0.0.1-SNAPSHOT.jar"]
