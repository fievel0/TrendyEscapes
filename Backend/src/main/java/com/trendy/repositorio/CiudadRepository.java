package com.trendy.repositorio;

import com.trendy.entidades.Paquete.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
