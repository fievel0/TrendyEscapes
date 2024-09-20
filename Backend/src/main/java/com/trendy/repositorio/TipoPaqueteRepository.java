package com.trendy.repositorio;

import com.trendy.entidades.Paquete.TipoPaquete;
import com.trendy.entidades.enums.TipoPaqueteEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPaqueteRepository extends JpaRepository<TipoPaquete, Long> {
    TipoPaquete getTipoPaqueteByDescripcion(TipoPaqueteEnum tipoPaquete);
}
