FROM openjdk:21-jdk
COPY target/redis-0.0.2-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
