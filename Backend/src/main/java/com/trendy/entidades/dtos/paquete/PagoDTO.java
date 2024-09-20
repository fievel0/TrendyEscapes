package com.trendy.entidades.dtos.paquete;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PagoDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String Nombres;
    @Email(message = "Correo electrónico no válido")
    @NotBlank(message = "El email no puede estar vacío")
    private String email;
     @Min(value = 50, message = "El monto debe ser mayor que 50")
    private double monto_Pago;
    @NotBlank(message = "El número de tarjeta no puede estar vacío")
    @Pattern(regexp = "^\\d{16,19}$", message = "El número de tarjeta debe tener entre 16 y 19 dígitos")
    private String num_Tarjeta;
    @NotBlank(message = "El código de seguridad no puede estar vacío")
    @Pattern(regexp = "^\\d{3}$", message = "El código de seguridad debe tener 3 dígitos")
    private String cod_Seguridad;
    @NotBlank(message = "El mes de vencimiento no puede estar vacío")
    @Pattern(regexp = "^(0[1-9]|1[0-2])$", message = "El mes de vencimiento debe ser un valor entre 01 y 12")
    private String mes_Venci;
    @NotBlank(message = "El año de vencimiento no puede estar vacío")
    @Future // Usa la nueva anotación personalizada
    private String ano_Venci;
}