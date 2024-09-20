# Usar OpenJDK 19 como imagen base
FROM openjdk:19-alpine AS build
WORKDIR /app

# Instalar Maven
RUN apk add --no-cache maven

# Copiar pom.xml y src desde el subdirectorio Backend
COPY Backend/pom.xml ./
COPY Backend/src ./src

# Construir el proyecto y generar el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Crear la imagen final
FROM openjdk:19-alpine
VOLUME /tmp

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Ejecutar la aplicación con el archivo JAR generado
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
