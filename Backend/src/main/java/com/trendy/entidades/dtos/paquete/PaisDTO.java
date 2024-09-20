package com.trendy.entidades.dtos.paquete;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@Data
@EqualsAndHashCode
@Builder
public class PaisDTO {
    private Long id_Pais;
    private String nombre_Pais;
 

}
