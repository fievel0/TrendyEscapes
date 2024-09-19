package com.trendy.servicio.paquete;

import com.trendy.entidades.Paquete.Paquete;
import com.trendy.entidades.dtos.paquete.PaqueteDTO;
import com.trendy.mapper.PaqueteMapper;
import com.trendy.repositorio.PaqueteRepository;
import com.trendy.servicio.paquete.filter.PaqueteSearchFilter;
import com.trendy.servicio.paquete.filter.PaqueteSearchFilterFactory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.plaf.IconUIResource;
import java.util.List;

@Service
public class PaqueteService {

    private final PaqueteRepository paqueteRepository;

    private final PaqueteMapper paqueteMapper;

    private final PaqueteSearchFilterFactory paqueteSearchFilterFactory;

    public PaqueteService(PaqueteRepository paqueteRepository, PaqueteMapper paqueteMapper, PaqueteSearchFilterFactory paqueteSearchFilterFactory) {
        this.paqueteRepository = paqueteRepository;
        this.paqueteMapper = paqueteMapper;
        this.paqueteSearchFilterFactory = paqueteSearchFilterFactory;
    }


    public Page<PaqueteDTO> getAllPaquetes(Pageable pageable, String criteria, String value) {
        Page<Paquete> paquetePage;
        if(criteria != null && value != null){
            PaqueteSearchFilter filter = paqueteSearchFilterFactory.getCriteria(criteria);
            paquetePage = filter != null ? filter.applyCriteria(pageable, value) : paqueteRepository.findAll(pageable);
        } else {
            paquetePage = paqueteRepository.findAll(pageable);
        }
        List<PaqueteDTO> paqueteDTOList = paqueteMapper.paquetesToPaquetesDTO(paquetePage.getContent());
        return new PageImpl<>(paqueteDTOList, pageable, paquetePage.getTotalElements());
    }

    public PaqueteDTO getSinglePaquete(Long id) {
        Paquete paquete = paqueteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paquete no encontrado con ID " + id));

        return paqueteMapper.paqueteToPaqueteDTO(paquete);
    }
}
