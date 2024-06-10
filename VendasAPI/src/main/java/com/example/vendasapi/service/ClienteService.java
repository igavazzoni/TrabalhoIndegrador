package com.example.vendasapi.service;

import com.example.vendasapi.model.Cliente;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;
import com.example.vendasapi.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Tag(name = "Cliente service", description = "Service da classe CLiente")
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService (ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

    }
     public List<Cliente> getAll() {return this.clienteRepository.findAll();}

    public Cliente save(Cliente cliente) {return clienteRepository.save(cliente);}

    public void deleteById(int id){this.clienteRepository.deleteById(id);}

    public Optional <Cliente>getById(int id){return this.clienteRepository.findById(id);}
}
