package com.trendy.entidades.dtos.paquete;


import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Información detallada sobre un paquete de viaje")
public record PaqueteDTO(
        @Schema(description = "Identificador único del paquete", example = "1")
        Long id,

        @Schema(description = "Nombre del paquete", example = "Escapada Tropical")
        String nombre,

        @Schema(description = "Descripción del paquete", example = "Un viaje relajante a islas tropicales con todas las comodidades.")
        String descripcion,

        @Schema(description = "Costo del paquete en la moneda local", example = "1200")
        int costo,

        @Schema(description = "Indica si el paquete incluye hotel", example = "true")
        boolean hotel,

        @Schema(description = "URL de la foto del paquete", example = "escapada_tropical.jpg")
        String foto,

        @Schema(description = "Tipo de paquete", example = "LUJO")
        String tipoPaquete,

        @Schema(description = "País en el que se ofrece el paquete", example = "Brasil")
        String pais,

        @Schema(description = "Lista de ciudades incluidas en el paquete", example = "[\"Río de Janeiro\", \"São Paulo\"]")
        List<String> ciudades
) { }
