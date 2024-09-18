package com.trendy.repositorio;

import com.trendy.entidades.Paquete.Pais;
import com.trendy.entidades.Paquete.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
}
