FROM openjdk:11
VOLUME /app
COPY target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
