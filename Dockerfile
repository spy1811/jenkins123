FROM eclipse-temurin:17
EXPOSE 8080
COPY target/*jar bankapplication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","bankapplication-0.0.1-SNAPSHOT.jar"]
