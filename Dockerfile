FROM openjdk:19-jdk
WORKDIR /app
COPY target/service-book-review-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8086
CMD ["java", "-jar", "app.jar"]
