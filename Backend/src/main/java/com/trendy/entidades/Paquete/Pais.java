package com.trendy.entidades.Paquete;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "pais")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pais;

    @Column(name = "nombre_pais", nullable = false, unique = true)
    private String nombrePais;

    @OneToMany(mappedBy = "pais")  // Referencia correcta al campo en Paquete
    private List<Paquete> paquete = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id_pais")  // Cambié id_ciudad por id_pais para que coincida
    private List<Ciudad> ciudad = new ArrayList<>();
}
