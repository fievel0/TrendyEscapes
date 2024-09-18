package com.trendy.entidades.Paquete;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "paquete")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paquete;

    @Column(name = "nombre_paquete", nullable = false, length = 100)
    private String nombrePaquete;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "costo_paquete")
    private int costoPaquete;

    @Column(name = "hotel")
    private boolean hotel;

    // Considera almacenar solo la URL si es posible
    @Column(name = "foto")
    private String foto;

    @ManyToMany
    @JoinTable(name = "paquete_ciudad",
            joinColumns = @JoinColumn(name = "id_paquete"),
            inverseJoinColumns = @JoinColumn(name = "id_ciudad"))
    @JsonProperty("ciudades")
    private List<Ciudad> ciudadList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_tipo_paquete", nullable = false)
    private TipoPaquete tipoPaquete;

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;

    @OneToMany(mappedBy = "paquete")
    private List<HistorialCompra> historialCompras = new ArrayList<>();
}