FROM openjdk:11

EXPOSE 8089

COPY ./build/libs/hello-world-0.0.1-SNAPSHOT.jar /usr/app/hello-world.jar
WORKDIR /usr/app

ENTRYPOINT ["java","-jar", "hello-world.jar"]