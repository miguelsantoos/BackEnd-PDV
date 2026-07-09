package com.cadastro.miguel.service;

import java.util.List;

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

    // Busca todos os clientes cadastrados
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    // Deleta todos do banco de dados
    public void deletarTodos() {
        clienteRepository.deleteAll();
    }

    // Deleta o cliente por id
    public void deletarPorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
