FROM amazoncorretto:19
MAINTAINER facuibars
COPY folder/Portafolio-0.0.1-SNAPSHOT.jar Portafolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Portafolio-0.0.1-SNAPSHOT.jar"]