package com.trendy.entidades.dtos.autenticacion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO que representa la respuesta de una autenticación exitosa.")
@JsonPropertyOrder({"email", "message", "jwt", "status"})
public record LoginResponseDTO(

        @Schema(
                description = "El correo electrónico del usuario autenticado.",
                example = "juan.perez@ejemplo.com"
        )
        String email,

        @Schema(
                description = "Mensaje de éxito o información adicional sobre la autenticación.",
                example = "Usuario autenticado satisfactoriamente"
        )
        String message,

        @Schema(
                description = "El token JWT generado para el usuario.",
                example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
        )
        String jwt,

        @Schema(
                description = "Estado de la autenticación, generalmente 'true' si la autenticación fue exitosa.",
                example = "true"
        )
        boolean status
) { }

