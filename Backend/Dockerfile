FROM amazoncorretto:19-alpine-jdk

# Instalar Maven
RUN apk add --no-cache maven

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar pom.xml y src desde el subdirectorio Backend
COPY Backend/pom.xml .
COPY Backend/src ./src

# Ejecutar Maven para construir el proyecto y generar el JAR
RUN mvn clean package -DskipTests

# Verificar que el archivo JAR esté en el directorio target
RUN ls target/

# Copiar el archivo JAR generado desde el directorio target
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Ejecutar la aplicación con el archivo JAR generado
ENTRYPOINT ["java", "-jar", "/app.jar"]
