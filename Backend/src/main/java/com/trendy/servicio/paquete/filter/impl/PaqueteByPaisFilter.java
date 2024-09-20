package com.trendy.servicio.paquete.filter.impl;

import com.trendy.entidades.Paquete.Paquete;
import com.trendy.repositorio.PaqueteRepository;
import com.trendy.servicio.paquete.filter.PaqueteSearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PaqueteByPaisFilter implements PaqueteSearchFilter {

    @Autowired
    private PaqueteRepository paqueteRepository;

    @Override
    public Page<Paquete> applyCriteria(Pageable pageable, String value) {
        return paqueteRepository.findByPaisNombrePaisContainingIgnoreCase(value, pageable);
    }

}
