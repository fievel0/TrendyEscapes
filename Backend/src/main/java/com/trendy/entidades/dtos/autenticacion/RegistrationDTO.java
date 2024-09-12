package com.trendy.entidades.dtos.autenticacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trendy.validaciones.UniqueDocumento;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(description = "DTO para el registro de un nuevo cliente en la plataforma.")
public record RegistrationDTO(

        @Schema(
                description = "El nombre completo del cliente.",
                example = "Juan Pérez"
        )
        @NotEmpty(message = "Nombre no puede estar vacio")
        String nombre,

        @Schema(
                description = "Número de teléfono del cliente. Debe tener exactamente 10 caracteres numéricos.",
                example = "1234567890"
        )
        @Size(min = 10, max = 10, message = "El teléfono debe tener exactamente 10 caracteres.")
        @Pattern(regexp = "\\d+", message = "El teléfono solo puede contener números.")
        String telefono,

        @Schema(
                description = "Número de documento del cliente. Debe tener exactamente 10 caracteres numéricos.",
                example = "9876543210"
        )
        @Size(min = 10, max = 10, message = "El número de documento debe tener exactamente 10 caracteres.")
        @Pattern(regexp = "\\d+", message = "El número de documento solo puede contener números.")
        @UniqueDocumento
        String documento,

        @Schema(
                description = "Fecha de nacimiento del cliente en formato 'yyyy-MM-dd'.",
                example = "1990-01-01"
        )
        @NotNull(message = "La fecha de nacimiento es obligatoria.")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate fechaNacimiento,

        @Schema(
                description = "El país de residencia del cliente.",
                example = "Chile",
                required = true
        )
        @NotEmpty(message = "Pais no puede estar vacio")
        String pais,

        @Schema(
                description = "Dirección del cliente. Debe tener entre 5 y 100 caracteres y solo permitir ciertos caracteres.",
                example = "Calle Chilena 123"
        )
        @NotBlank(message = "La dirección es obligatoria")
        @Size(min = 5, max = 100, message = "La dirección debe tener entre 5 y 100 caracteres")
        @Pattern(regexp = "^[a-zA-Z0-9\\s,.-]+$", message = "La dirección contiene caracteres inválidos")
        String direccion,

        @Schema(
                description = "Datos de autenticación del cliente.",
                implementation = AuthenticationDTO.class
        )
        @Valid
        AuthenticationDTO autenticacion

) { }

