package com.example.vendasapi.controller;

import com.example.vendasapi.model.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.vendasapi.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Cliente API", description = "API Controller para gerenciar dados de clientes")
public class ClienteApiController {
    private final ClienteService clienteService;

    public ClienteApiController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @PostMapping(path = "/api/cliente")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @GetMapping(path = "/api/cliente")
    public ResponseEntity<List<Cliente>> getAll(){return ResponseEntity.ok(clienteService.getAll());}

    @Operation(summary = "Opera o ID dos Clientes",
            description = "Incrementa ID dos clientes",
            parameters = {
                    @Parameter(name = "ID Cliente", description = "ID sera adicionado ao cliente " +
                            "Index de cada cliente é unico.")
            })
    @GetMapping(path ="/api/cliente/{id}" )
    public ResponseEntity<Cliente> getById(@PathVariable int id){
        Optional<Cliente> cliente = clienteService.getById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Operation(summary = "Atualiza dados doCliente",
            description = "Pode-se Atualizar os dados do cliente selecionado",
            parameters = {
                    @Parameter(name = "Cliente", description = "dados do Cliente sera atualizado " +
                            "ID nunca pode ser atualizado ou alterado.")
            })
    @PutMapping("/api/cliente/update/{id}")
    public ResponseEntity<Cliente> update(@PathVariable int id, @RequestBody Cliente cliente){
        Optional<Cliente> clienteOptional = clienteService.getById(id);
        if(clienteOptional.isPresent()){
            cliente.setId(id);
            Cliente upCliente = clienteService.save(cliente);
            return ResponseEntity.ok(upCliente);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/api/cliente/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        if(clienteService.getById(id).isPresent()){
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
