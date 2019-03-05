FROM openjdk:8

COPY . /.

RUN ./gradlew clean build

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "application/build/clean-architecture-example.war"]
