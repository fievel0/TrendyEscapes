package com.trendy.entidades.dtos.autenticacion;

import com.trendy.validaciones.UniqueEmail;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Schema(description = "DTO para la autenticación de usuario.")
public record AuthenticationDTO(

        @Schema(
                description = "El correo electrónico del usuario.",
                example = "juan.perez@ejemplo.com",
                minLength = 1
        )
        @NotEmpty(message = "Email no puede estar vacio")
        @Email(message = "Email debe estar en formato valido")
        @UniqueEmail
        String email,

        @Schema(
                description = "La contraseña del usuario. Debe tener al menos 12 caracteres, incluir una mayúscula, una minúscula, un número y un carácter especial.",
                example = "ContraseñaSegura!123",
                minLength = 12
        )
        @NotEmpty(message = "Contrasena no puede estar vacia")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{12,}$",
                message = "Contrasena debe ser al menos de 12 caracteres, contener una mayúscula, una minúscula, un número y un carácter especial")
        String password
) { }
