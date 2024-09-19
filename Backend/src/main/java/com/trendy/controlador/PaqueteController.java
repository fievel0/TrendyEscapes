package com.trendy.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trendy.entidades.dtos.paquete.PaqueteDTO;
import com.trendy.servicio.paquete.PaqueteService;


@RestController
@CrossOrigin
@RequestMapping("/paquetes")
public class PaqueteController {

    private final PaqueteService paqueteService;

    @Autowired
    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<Page<PaqueteDTO>> getPaquetes(@RequestParam(name = "criteria", required = false) String criteria,
                                                        @RequestParam(name = "value", required = false) String value,
                                                        @PageableDefault(direction = Sort.Direction.ASC, size = 25)  Pageable pageable){
        Page<PaqueteDTO> paquetesEnBase = paqueteService.getAllPaquetes(pageable, criteria, value);
        return ResponseEntity.ok(paquetesEnBase);
    }

}
