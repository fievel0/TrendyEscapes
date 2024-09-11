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
    @Column(name = "id_auth")
    private Long idAutenticacion;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "contrasena",  nullable = false)
    private String password;


}
