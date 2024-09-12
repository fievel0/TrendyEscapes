package com.trendy.servicio;

import com.trendy.entidades.cliente.Cliente;
import com.trendy.entidades.dtos.cliente.ClienteInfoDTO;
import com.trendy.mapper.ClienteMapper;
import com.trendy.repositorio.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper){
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Transactional(readOnly = true)
    public ClienteInfoDTO obtenerCliente(Long id){

        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new EntityNotFoundException("Cliente no encontrado con ID " + id);
        }

        return clienteMapper.clienteToClienteDTO(cliente.get());
    }

}
