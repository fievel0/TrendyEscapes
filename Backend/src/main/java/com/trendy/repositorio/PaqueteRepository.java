package com.trendy.repositorio;

import com.trendy.entidades.Paquete.Paquete;
import com.trendy.entidades.Paquete.TipoPaquete;
import com.trendy.entidades.enums.TipoPaqueteEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
    Page<Paquete> findByPaisNombrePaisContainingIgnoreCase(String pais, Pageable pageable);

    Page<Paquete> findByCostoPaqueteGreaterThanEqualOrderByCostoPaqueteAsc(int value, Pageable pageable);

    @Query("""
            SELECT p FROM Paquete p WHERE p.hotel = :hotel
            """)
    Page<Paquete> findByHotel(@Param("hotel") Boolean hotel, Pageable pageable);

    Page<Paquete> findByTipoPaqueteDescripcion(TipoPaqueteEnum tipoPaquete, Pageable pageable);

}
