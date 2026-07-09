package com.cadastro.miguel.mapper;

import com.cadastro.miguel.dto.ClienteRequest;
import com.cadastro.miguel.dto.ClienteResponse;
import com.cadastro.miguel.entity.Cliente;

public class ClienteMapper {
    

    public static Cliente toEntity(ClienteRequest clienteRequest) {

        Cliente cliente = new Cliente();

        cliente.setNome(clienteRequest.nome());
        cliente.setEmail(clienteRequest.email());
        cliente.setSenha(clienteRequest.senha());
        
        return cliente;
    }


    public static ClienteResponse toResponse(Cliente cliente) {
            
        return new ClienteResponse(
            cliente.getId(),
            cliente.getNome(),
            cliente.getEmail()
        );  
    }
}

