FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

ADD target/demoAuthorizationService-0.0.1-SNAPSHOT.jar das.jar

CMD ["java", "-jar", "das.jar"]