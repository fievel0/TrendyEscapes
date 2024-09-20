# Usar OpenJDK 19 como imagen base
FROM openjdk:19-jdk AS build
WORKDIR /app

# Copiar pom.xml y src desde el subdirectorio Backend
COPY Backend/pom.xml ./
COPY Backend/src ./src

# Instalar Maven
RUN apt-get update && apt-get install -y maven

# Construir el proyecto y generar el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Crear la imagen final
FROM openjdk:19-jdk
VOLUME /tmp

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Ejecutar la aplicación con el archivo JAR generado
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
