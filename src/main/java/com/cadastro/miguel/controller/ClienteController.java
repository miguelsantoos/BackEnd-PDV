package com.cadastro.miguel.controller;

import java.net.URI;
import java.rmi.server.ServerCloneException;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cadastro.miguel.dto.ClienteRequest;
import com.cadastro.miguel.dto.ClienteResponse;
import com.cadastro.miguel.entity.Cliente;
import com.cadastro.miguel.service.ClienteService;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/clientes")
@RestController
public class ClienteController {
    
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Recebe as informações do cliente
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody ClienteRequest clienteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.cadastrar(clienteRequest));
    }

    // Recebe a chamada para buscar todos os clientes
    @GetMapping
    public List<ClienteResponse> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(@RequestParam Long id) {
        return clienteService.buscarPorId(id);
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
