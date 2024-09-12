package com.trendy.entidades.dtos.cliente;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO que representa la información de un cliente.")
@JsonPropertyOrder({"idCliente", "nombre", "email", "documento", "fechaNacimiento", "direccion", "pais", "numTelefono"})
public record ClienteInfoDTO(

        @Schema(
                description = "ID único del cliente.",
                example = "1"
        )
        Long idCliente,

        @Schema(
                description = "Nombre completo del cliente.",
                example = "Juan Pérez"
        )
        String nombre,

        @Schema(
                description = "Correo electrónico del cliente.",
                example = "juan.perez@ejemplo.com"
        )
        String email,

        @Schema(
                description = "Número de documento del cliente.",
                example = "9876543210"
        )
        String documento,

        @Schema(
                description = "Fecha de nacimiento del cliente en formato 'yyyy-MM-dd'.",
                example = "1990-01-01"
        )
        String fechaNacimiento,

        @Schema(
                description = "Dirección del cliente.",
                example = "Calle Chilena 123"
        )
        String direccion,

        @Schema(
                description = "País de residencia del cliente.",
                example = "Chile"
        )
        String pais,

        @Schema(
                description = "Número de teléfono del cliente.",
                example = "1234567890"
        )
        String numTelefono

) { }
