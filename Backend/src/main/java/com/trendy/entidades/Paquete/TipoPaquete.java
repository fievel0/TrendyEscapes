package com.trendy.entidades.Paquete;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tipo_paquete")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoPaquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_paquete")
    private Long idTipoPaquete;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "tipoPaquete")
    private List<Paquete> paquetes = new ArrayList<>();
}
