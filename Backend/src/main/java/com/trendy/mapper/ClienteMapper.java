package com.trendy.mapper;

import com.trendy.entidades.cliente.Cliente;
import com.trendy.entidades.dtos.autenticacion.RegistrationDTO;
import com.trendy.entidades.dtos.cliente.ClienteInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {


    PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();

    @Mapping(target = "idCliente", ignore = true)
    @Mapping(target = "historialCompras", ignore = true)
    @Mapping(target = "numTelefono", source = "telefono")
    @Mapping(target = "numDocumento", source = "documento")
    @Mapping(target = "pais.nombrePais", source = "pais")
    @Mapping(target = "autenticacion.email", source = "autenticacion.email")
    @Mapping(target = "autenticacion.password", source = "autenticacion.password", qualifiedByName = "mapPassword")
    Cliente registrarCliente(RegistrationDTO registrationDTO);

    @Mapping(target = "documento", source = "numDocumento")
    @Mapping(target = "pais", source = "pais.nombrePais")
    @Mapping(target = "email", source = "autenticacion.email")
    ClienteInfoDTO clienteToClienteDTO(Cliente clientRegistered);

    @Named("mapPassword")
    default String mapPassword(String password){
        return passwordEncoder.encode(password);
    }
}
