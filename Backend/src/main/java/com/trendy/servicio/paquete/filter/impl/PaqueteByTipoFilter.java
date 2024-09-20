package com.trendy.servicio.paquete.filter.impl;

import com.trendy.entidades.Paquete.Paquete;
import com.trendy.entidades.Paquete.TipoPaquete;
import com.trendy.entidades.enums.TipoPaqueteEnum;
import com.trendy.repositorio.PaqueteRepository;
import com.trendy.servicio.paquete.filter.PaqueteSearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PaqueteByTipoFilter implements PaqueteSearchFilter {


    @Autowired
    private PaqueteRepository paqueteRepository;

    @Override
    public Page<Paquete> applyCriteria(Pageable pageable, String value) {
        try{
            TipoPaqueteEnum tipoPaquete = TipoPaqueteEnum.valueOf(value.toUpperCase());
            return paqueteRepository.findByTipoPaqueteDescripcion(tipoPaquete, pageable);
        } catch (RuntimeException e){
            throw new EnumConstantNotPresentException(TipoPaqueteEnum.class, value);
        }
    }

}
