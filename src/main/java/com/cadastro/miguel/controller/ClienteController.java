package com.cadastro.miguel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.miguel.entity.Cliente;
import com.cadastro.miguel.service.ClienteService;

@RequestMapping("/clientes")
@RestController
public class ClienteController {
    
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Recebe as informações do cliente
    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return clienteService.cadastrar(cliente);
    }

    // Recebe a chamada para buscar todos os clientes
    @GetMapping
    public List<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }

    // Deleta todos os clientes
    @DeleteMapping
    public void deletarTodos() {
        clienteService.deletarTodos();
    }

    // Deleta o cliente por id
    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        clienteService.deletarPorId(id);
    }

}
