package com.cadastro.miguel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cadastro.miguel.dto.ClienteRequest;
import com.cadastro.miguel.dto.ClienteResponse;
import com.cadastro.miguel.entity.Cliente;
import com.cadastro.miguel.mapper.ClienteMapper;
import com.cadastro.miguel.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    
    public  ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    } 

    // cadastrar cliente
    public ClienteResponse cadastrar(ClienteRequest clienteRequest) {

        // Verifica se já existe email cadastrado
        if (clienteRepository.existsByEmailEquals(clienteRequest.email())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        Cliente cliente = ClienteMapper.toEntity(clienteRequest);
        return ClienteMapper.toResponse(clienteRepository.save(cliente));
    }

    // Busca todos os clientes cadastrados
    public List<ClienteResponse> buscarTodos() {
        return clienteRepository.findAll().stream().map(ClienteMapper::toResponse).toList();
    }

    // Busca o cliente por id
    public ClienteResponse buscarPorId(Long id) {

        Cliente cliente = clienteRepository.findById(id)
                            .orElseThrow( () -> 
                                new IllegalArgumentException("Cliente não encontrado"));

        return ClienteMapper.toResponse(cliente);
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
