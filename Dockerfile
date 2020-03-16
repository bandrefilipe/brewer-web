FROM gradle:jdk11-slim AS builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:11-jre-slim
LABEL author="Andre Filipe Barranco"
LABEL email="b.andrefilipe@gmail.com"
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/
WORKDIR /app
ENTRYPOINT java -jar *.jar
EXPOSE 8080
