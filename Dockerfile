FROM openjdk:8-jdk
VOLUME /tmp
COPY target/avaliacao-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]