# Étape 1 : Construire l'application avec Maven
FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Étape 2 : Créer l'image de l'application
FROM openjdk:17-jdk-slim
COPY --from=build /home/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
