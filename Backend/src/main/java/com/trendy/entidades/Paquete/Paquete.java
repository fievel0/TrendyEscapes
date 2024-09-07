package com.trendy.entidades.Paquete;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Paquete")
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paquete;
    private String nombre_paquete;
    private int costo_paquete;
    private String hotel;
    private Byte foto;

    @ManyToMany
    @JoinColumn(name="id_paquete_ciudad", nullable=false)
    private List<Paquete_Ciudad> paqueteciudadList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="id_tipo_paquete", nullable = false)
    private Tipo_paquete tipo_paquete;

    @OneToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;
}   
