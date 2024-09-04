package com.trendy.entidades.cliente;

import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;

    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auth_id", referencedColumnName = "autenticacion_id")
    private Autenticacion autenticacion;

}
