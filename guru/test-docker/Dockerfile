FROM eclipse-temurin:21
LABEL authors="Hung" maintainer="duchung04st@gmail.com"


WORKDIR /app

COPY target/test-docker-0.0.1-SNAPSHOT.jar /app/spring-boot-docker-demo.jar

ENTRYPOINT ["java", "-jar", "/app/spring-boot-docker-demo.jar"]