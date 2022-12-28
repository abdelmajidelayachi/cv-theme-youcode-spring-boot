FROM openjdk:17
#make app directory
RUN mkdir /app
ADD target/cvtheme-spring-boot.jar /app/cvtheme-spring-boot.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cvtheme-spring-boot.jar"]
