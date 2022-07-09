FROM openjdk:11

EXPOSE 8089

WORKDIR /applications
COPY target/hello-world-0.0.1-SNAPSHOT.jar /applications/hello-world.jar

ENTRYPOINT ["java","-jar", "hello-world.jar"]