package com.trendy.entidades.Paquete;

import com.trendy.entidades.enums.TipoPaqueteEnum;
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
    @Enumerated(EnumType.STRING)
    private TipoPaqueteEnum descripcion;

    @OneToMany(mappedBy = "tipoPaquete", fetch = FetchType.EAGER)
    private List<Paquete> paquetes = new ArrayList<>();

    public TipoPaquete(String tipoPaquete){
        this.descripcion = TipoPaqueteEnum.valueOf(tipoPaquete);
    }

}
