package com.trendy.entidades.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "autenticacion")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Autenticacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autenticacion_id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    @OneToOne(mappedBy = "autenticacion")
    private Cliente cliente_id;


}
