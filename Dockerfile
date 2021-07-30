FROM openjdk:11
COPY target/poc-activity-log-ms.jar poc-activity-log-ms.jar
EXPOSE 9096
ENTRYPOINT ["java", "-jar", "poc-activity-log-ms.jar"]