package com.example.vendasapi.controller;

import com.example.vendasapi.model.ItemVenda;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.vendasapi.service.ItemVendaService;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Atendimento API", description = "API para gerenciamento dos atendimentos")
public class ItemVendaApiController {
    private final ItemVendaService itemVendaService;

    public ItemVendaApiController(ItemVendaService itemVendaService) {
        this.itemVendaService = itemVendaService;
    }

    @PostMapping(path = "/api/itemVenda")
    public ResponseEntity<ItemVenda> save(@RequestBody ItemVenda itemVenda) {
        return ResponseEntity.ok(itemVendaService.save(itemVenda));
    }

    @GetMapping(path = "/api/itemVenda")
    public ResponseEntity<List<ItemVenda>> getAll() { return ResponseEntity.ok(itemVendaService.getAll()); }

    @GetMapping(path = "/api/itemVenda/{id}")
    public ResponseEntity<ItemVenda> getById(@PathVariable int id) {
        Optional<ItemVenda> itemVenda = itemVendaService.getById(id);
        return itemVenda.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/api/itemVenda/uptade/{id}")
    public ResponseEntity<ItemVenda> update(@PathVariable Integer id, @RequestBody ItemVenda itemVenda) {
        Optional<ItemVenda> vendaOptional = itemVendaService.getById(id);
        if(vendaOptional.isPresent()) {
            itemVenda.setId(id);
            ItemVenda upItemVenda = itemVendaService.save(itemVenda);
            return ResponseEntity.ok(upItemVenda);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping(path = "/api/itemVenda/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        if(itemVendaService.getById(id).isPresent()) {
            itemVendaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
