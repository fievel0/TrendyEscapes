package com.trendy.entidades.dtos.autenticacion;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record LoginRequestDTO(
        @Email String email,
        @NotEmpty String password
) { }
