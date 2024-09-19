package com.trendy.entidades.dtos.paquete;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"id","nombre", "descripcion", "costo", "tipoPaquete", "pais", "ciudades", "hotel", "foto"})
public record PaqueteDTO(Long id,
                         String nombre,
                         String descripcion,
                         int costo,
                         boolean hotel,
                         String foto,
                         String tipoPaquete,
                         String pais,
                         List<String> ciudades
                         ) {
}
