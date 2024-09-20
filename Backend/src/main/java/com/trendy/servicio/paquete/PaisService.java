package com.trendy.servicio.paquete;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendy.entidades.Paquete.Pais;
import com.trendy.repositorio.PaisRepository;

@Service
public class PaisService {
     private final PaisRepository paisRepository;

    @Autowired
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public Optional<Pais> findById(Long id_Pais) {
        return paisRepository.findById(id_Pais);
    }

    public Optional<Pais> findByNombrePais(String nombrePais) {
        return paisRepository.findByNombrePais(nombrePais);
    }

    public boolean existsByNombrePais(String nombrePais) {
        return paisRepository.existsByNombrePais(nombrePais);
    }

    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    public void deleteById(Long id_Pais) {
        paisRepository.deleteById(id_Pais);
    }
    
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }
}