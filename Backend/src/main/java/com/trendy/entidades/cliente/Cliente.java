package com.trendy.entidades.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autenticacion", referencedColumnName = "id_auth", nullable = false)
    private Autenticacion autenticacion;

    @Column(name = "num_documento", nullable = false)
    private String numDocumento;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    private String direccion;

    @Column(name = "num_telefono")
    private String numTelefono;
    







}
