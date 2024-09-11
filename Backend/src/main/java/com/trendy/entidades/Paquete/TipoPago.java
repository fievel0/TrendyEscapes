package com.trendy.entidades.Paquete;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tipo_pago")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class TipoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pago")
    private Long idTipoPago;

    @Column(name = "nombre_tipo_pago")
    private String nombreTipoPago;

    @OneToMany(mappedBy = "tipoPago")
    private List<HistorialCompra> historialCompras = new ArrayList<>();
}
