package com.trendy.entidades.dtos.autenticacion;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "DTO para la solicitud de inicio de sesión del usuario.")
public record LoginDTO(

        @Schema(
                description = "El correo electrónico del usuario utilizado para iniciar sesión.",
                example = "juan.perez@ejemplo.com"
        )
        @NotEmpty(message = "Email no puede estar vacio")
        String email,

        @Schema(
                description = "La contraseña del usuario para el inicio de sesión.",
                example = "ContraseñaSegura!123"
        )
        @NotEmpty(message = "Contrasena no puede estar vacia")
        String password
) { }

