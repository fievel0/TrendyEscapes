package com.trendy.entidades.Paquete;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pais")

public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id_pais;
    private String nombre_pais;

    @OneToMany(mappedBy = "id_paquete")
    private Paquete paquete;

    @OneToMany
    @JoinColumn(name="id_ciudad", nullable = false)
    private Ciudad ciudad;
}
