package com.trendy.validaciones;

import com.trendy.excepcion.DuplicatedDataException;
import com.trendy.repositorio.ClienteRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (clienteRepository.existsByAutenticacionEmail(email)) {
            throw new DuplicatedDataException("El email ya está registrado: " + email);
        }
            return true;
    }
}