FROM openjdk:8-jre-alpine
COPY ./new-app/build/libs/new-app-0.0.1-SNAPSHOT.jar /usr/src/webflux-news/
WORKDIR /usr/src/webflux-news
CMD ["java", "-jar", "new-app-0.0.1-SNAPSHOT.jar"]