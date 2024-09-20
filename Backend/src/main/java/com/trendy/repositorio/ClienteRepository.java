package com.trendy.repositorio;

import com.trendy.entidades.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findClienteByAutenticacionEmail(String email);

    boolean existsByAutenticacionEmail(String email);

    boolean existsByNumDocumento(String documento);
}
