package com.cadastro.miguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.miguel.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    
}
