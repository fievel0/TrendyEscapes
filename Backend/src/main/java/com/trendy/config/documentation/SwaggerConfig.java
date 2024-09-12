package com.trendy.config.documentation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "Trendy Escapes API",
                description = """
                API REST para gestionar la reserva de paquetes turísticos a destinos alrededor del mundo. Ofrece operaciones para búsqueda, reserva y administración de viajes.

                Para comenzar, utiliza el endpoint **`auth/register`** para registrar un usuario. Luego, accede al endpoint **`auth/login`** para generar un token JWT utilizando el email y la contraseña del usuario.

                Este token JWT debe ser incluido en el encabezado de autorización para acceder a cualquier endpoint que no sea el de autenticación o registro. El token es necesario para la protección de los recursos y garantizar la seguridad de las operaciones.
                """,
                version = "1.0.0",
                termsOfService = "https://trendyescapes.com/terminos-de-uso",
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        ),
        servers = {
                @Server(
                        description = "Servidor de Desarrollo",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Servidor de Producción",
                        url = "https://api.trendyescapes.com"
                ),
                @Server(
                        description = "Servidor de Pruebas",
                        url = "https://staging.trendyescapes.com"
                )
        },
        security = @SecurityRequirement(
                name = "JWT Token"
        )
)
@SecurityScheme(
        name = "JWT Token",
        description = "JWT token de acceso para la API. Tiene una duración de 1 hora, después de lo cual se necesita iniciar sesión nuevamente.",
        scheme = "bearer",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER,
        paramName = HttpHeaders.AUTHORIZATION
)

public class SwaggerConfig { }
