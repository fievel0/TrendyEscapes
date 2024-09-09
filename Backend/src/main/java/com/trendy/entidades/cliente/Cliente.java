package com.trendy.entidades.cliente;

import com.trendy.entidades.Paquete.HistorialCompra;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(nullable = false, length = 100)
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autenticacion", referencedColumnName = "id_auth", nullable = false)
    private Autenticacion autenticacion;

    @Column(name = "num_documento", nullable = false, unique = true)
    private String numDocumento;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "num_telefono")
    private String numTelefono;

    @OneToMany(mappedBy = "cliente")
    private List<HistorialCompra> historialCompras = new ArrayList<>();
}

