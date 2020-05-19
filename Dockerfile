FROM openjdk:8
WORKDIR '/app'
ADD target/docker-springboot-example-0.0.1-SNAPSHOT.jar docker-springboot-example-0.0.1-SNAPSHOT.jar
EXPOSE 8086
COPY . .
ENTRYPOINT ["java", "-jar", "docker-springboot-example-0.0.1-SNAPSHOT.jar"]