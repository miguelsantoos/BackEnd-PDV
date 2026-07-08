package com.cadastro.miguel.service;

import org.springframework.stereotype.Service;

import com.cadastro.miguel.entity.Cliente;
import com.cadastro.miguel.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    
    public  ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    } 

    // cadastrar cliente
    public Cliente cadastrar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
