package com.example.vendasapi.controller;


import com.example.vendasapi.model.Venda;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.vendasapi.service.VendaService;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Venda API", description = "API para gerenciamento das vendas")
public class VendaApiController {
    private final VendaService vendaService;

    public VendaApiController(VendaService vendaService) {
        this.vendaService = vendaService;
    }


    @Operation(summary = "Salva as dados dos clientes", description = "Salva o Banco de dados")
    @PostMapping(path = "/api/venda")
    public ResponseEntity<Venda> save(@RequestBody Venda venda) {
        return ResponseEntity.ok(vendaService.save(venda));
    }


    @Operation(summary = "Obter todas Vendas", description = "Retorna uma lista de todas as Vendas")
    @GetMapping(path = "/api/venda")
    public ResponseEntity<List<Venda>> getAll(){return ResponseEntity.ok(vendaService.getAll());}


    @GetMapping(path ="/api/venda/{id}" )

    public ResponseEntity<Venda> getById(@PathVariable int id){
        Optional<Venda> venda = vendaService.getById(id);
        return venda.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/api/venda/update/{id}")
    public ResponseEntity<Venda> update(@PathVariable int id, @RequestBody Venda venda){
        Optional<Venda> vendaOptional = vendaService.getById(id);
        if(vendaOptional.isPresent()){
            venda.setId(id);
            Venda upVenda = vendaService.save(venda);
            return ResponseEntity.ok(upVenda);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/api/venda/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        if(vendaService.getById(id).isPresent()){
            vendaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
