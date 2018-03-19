FROM openjdk:8-jdk-alpine

LABEL maintainer='Piotr Nowak'

RUN adduser -D -g '' spring

COPY ./backend/build/libs/*.jar /home/spring

WORKDIR /home/spring
RUN mv *.jar app.jar && \
    chown spring:spring app.jar

EXPOSE 8080
USER spring

ENTRYPOINT ["java", "-jar"]
CMD ["app.jar"]
