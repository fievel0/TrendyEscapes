package com.trendy.entidades.dtos.autenticacion;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email", "message", "jwt", "status"})
public record LoginResponseDTO(

        String email,

        String message,

        String jwt,

        boolean status) {
}
