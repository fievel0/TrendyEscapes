package com.trendy.servicio.paquete.filter;

import com.trendy.entidades.Paquete.Paquete;
import com.trendy.repositorio.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaqueteSearchFilter {

    Page<Paquete> applyCriteria(Pageable pageable, String value);

}
