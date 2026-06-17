
#high level 
#maven image - builds your java app
#java image -> runs your finished app 

#use a docker image that already has maven and java 21 installed
FROM maven:3.9.8-eclipse-temurin-21 AS build

#sets the working folder inside the temporay build container
WORKDIR /app

#copies the maven project file into the container
COPY pom.xml

#copy our java source code into the container
COPY src ./src

#builds our spring boot app into a .jar file
RUN mvn clean package -DskipTests

#use a smaller java runtime image for actually running the app
FROM eclipse-emurin:21-jre-alpine

#sets the working folder inside the final running container 
WORKDIR /app

#copies the built .jar file form the build container 
COPY --from=build /app/target/todo-0.0.1-SNAPSHOT.jar app.jar

#says the app uses port 3000
EXPOSE 3000

#runs the spring boot app
CMD["java", "-jar", "app.jar"]

