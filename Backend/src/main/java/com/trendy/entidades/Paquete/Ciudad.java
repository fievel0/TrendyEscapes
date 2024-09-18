package com.trendy.entidades.Paquete;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ciudad")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Long idCiudad;  // Este campo no debería tener insertable=false ni updatable=false

    @Column(name = "nombre_ciudad", unique = true, nullable = false)
    private String nombreCiudad;

    @ManyToMany(mappedBy = "ciudadList", fetch = FetchType.EAGER)  // Debe referirse al campo en Paquete
    private List<Paquete> paqueteList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais idPais;

    public Ciudad(String ciudadString){
        this.nombreCiudad = ciudadString;
    }

}
