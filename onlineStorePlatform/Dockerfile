#FROM openjdk:8
#EXPOSE 8080
#ADD target/onlineStorePlatform.jar onlineStorePlatform.jar
#ENTRYPOINT ["java" , "-jar" , "/onlineStorePlatform.jar"]

# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy fat WAR
COPY target/onlineStorePlatform.jar /onlineStorePlatform.war
# runs application
CMD ["java", "-jar", "-Dspring.profiles.active=default", "/onlineStorePlatform.war"]