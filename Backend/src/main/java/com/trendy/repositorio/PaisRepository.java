package com.trendy.repositorio;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trendy.entidades.Paquete.Pais;


@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

    Pais getPaisByNombrePais(String nombrePais);
    
    @Override
    Optional<Pais> findById(Long id_Pais);
    
    Optional<Pais> findByNombrePais(String nombrePais);

    boolean existsByNombrePais(String nombrePais);

   

    @Override
    void deleteById(Long id_Pais);
}


