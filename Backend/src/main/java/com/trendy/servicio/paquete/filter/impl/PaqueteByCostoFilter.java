package com.trendy.servicio.paquete.filter.impl;

import com.trendy.entidades.Paquete.Paquete;
import com.trendy.repositorio.PaqueteRepository;
import com.trendy.servicio.paquete.filter.PaqueteSearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PaqueteByCostoFilter implements PaqueteSearchFilter {

    @Autowired
    private PaqueteRepository paqueteRepository;

    @Override
    public Page<Paquete> applyCriteria(Pageable pageable, String value) {
        int intValue;
        try{
            intValue = Integer.parseInt(value);
            return paqueteRepository.findByCostoPaqueteGreaterThanEqualOrderByCostoPaqueteAsc(intValue, pageable);
        }catch(NumberFormatException e){
            throw new NumberFormatException("Valor enviado como parametro para costo no es valido");
        }
    }
}
