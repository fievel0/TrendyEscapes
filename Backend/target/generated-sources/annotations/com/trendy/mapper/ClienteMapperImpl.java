package com.trendy.mapper;

import com.trendy.entidades.Paquete.Pais;
import com.trendy.entidades.cliente.Autenticacion;
import com.trendy.entidades.cliente.Cliente;
import com.trendy.entidades.dtos.autenticacion.AuthenticationDTO;
import com.trendy.entidades.dtos.autenticacion.RegistrationDTO;
import com.trendy.entidades.dtos.cliente.ClienteInfoDTO;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-21T10:51:02-0500",
    comments = "version: 1.6.0.Beta2, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente registrarCliente(RegistrationDTO registrationDTO) {
        if ( registrationDTO == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setPais( registrationDTOToPais( registrationDTO ) );
        cliente.setAutenticacion( authenticationDTOToAutenticacion( registrationDTO.autenticacion() ) );
        cliente.setNumTelefono( registrationDTO.telefono() );
        cliente.setNumDocumento( registrationDTO.documento() );
        cliente.setDireccion( registrationDTO.direccion() );
        cliente.setFechaNacimiento( registrationDTO.fechaNacimiento() );
        cliente.setNombre( registrationDTO.nombre() );

        return cliente;
    }

    @Override
    public ClienteInfoDTO clienteToClienteDTO(Cliente clientRegistered) {
        if ( clientRegistered == null ) {
            return null;
        }

        String documento = null;
        String pais = null;
        String email = null;
        Long idCliente = null;
        String nombre = null;
        String fechaNacimiento = null;
        String direccion = null;
        String numTelefono = null;

        documento = clientRegistered.getNumDocumento();
        pais = clientRegisteredPaisNombrePais( clientRegistered );
        email = clientRegisteredAutenticacionEmail( clientRegistered );
        idCliente = clientRegistered.getIdCliente();
        nombre = clientRegistered.getNombre();
        if ( clientRegistered.getFechaNacimiento() != null ) {
            fechaNacimiento = DateTimeFormatter.ISO_LOCAL_DATE.format( clientRegistered.getFechaNacimiento() );
        }
        direccion = clientRegistered.getDireccion();
        numTelefono = clientRegistered.getNumTelefono();

        ClienteInfoDTO clienteInfoDTO = new ClienteInfoDTO( idCliente, nombre, email, documento, fechaNacimiento, direccion, pais, numTelefono );

        return clienteInfoDTO;
    }

    protected Pais registrationDTOToPais(RegistrationDTO registrationDTO) {
        if ( registrationDTO == null ) {
            return null;
        }

        Pais pais = new Pais();

        pais.setNombrePais( registrationDTO.pais() );

        return pais;
    }

    protected Autenticacion authenticationDTOToAutenticacion(AuthenticationDTO authenticationDTO) {
        if ( authenticationDTO == null ) {
            return null;
        }

        Autenticacion autenticacion = new Autenticacion();

        autenticacion.setEmail( authenticationDTO.email() );
        autenticacion.setPassword( mapPassword( authenticationDTO.password() ) );

        return autenticacion;
    }

    private String clientRegisteredPaisNombrePais(Cliente cliente) {
        Pais pais = cliente.getPais();
        if ( pais == null ) {
            return null;
        }
        return pais.getNombrePais();
    }

    private String clientRegisteredAutenticacionEmail(Cliente cliente) {
        Autenticacion autenticacion = cliente.getAutenticacion();
        if ( autenticacion == null ) {
            return null;
        }
        return autenticacion.getEmail();
    }
}
