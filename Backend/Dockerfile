FROM amazoncorretto:19-alpine-jdk

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos necesarios para compilar la aplicación
COPY pom.xml .
COPY src ./src

# Ejecutar Maven para construir el proyecto y generar el JAR
RUN ./mvnw clean package -DskipTests

# Copiar el archivo JAR generado a la ruta donde será ejecutado
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Ejecutar la aplicación con el archivo JAR generado
ENTRYPOINT ["java", "-jar", "/app.jar"]
