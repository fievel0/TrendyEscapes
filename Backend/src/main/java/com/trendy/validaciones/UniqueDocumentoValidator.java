package com.trendy.validaciones;

import com.trendy.excepcion.DuplicatedDataException;
import com.trendy.repositorio.ClienteRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueDocumentoValidator implements ConstraintValidator<UniqueDocumento, String> {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public void initialize(UniqueDocumento constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String documento, ConstraintValidatorContext context) {
        if (clienteRepository.existsByNumDocumento(documento)) {
            throw new DuplicatedDataException("El documento ya está registrado: " + documento);
        }
        return true;
    }
}

