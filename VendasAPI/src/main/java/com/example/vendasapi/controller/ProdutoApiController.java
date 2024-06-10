package com.example.vendasapi.controller;

import com.example.vendasapi.model.Produto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.vendasapi.service.ProdutoService;

import java.util.List;
import java.util.Optional;
@RestController
@Tag(name = "Produto API", description = "API para gerenciamento dos Produtos")
public class ProdutoApiController {

    private final ProdutoService produtoService;

    public ProdutoApiController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    @PostMapping(path = "/api/produto")
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.save(produto));
    }
    @GetMapping(path = "/api/produto")
    public ResponseEntity<List<Produto>> getAll(){ return ResponseEntity.ok(produtoService.getAll()); }

    @GetMapping(path = "/api/produto/{id}")
    public ResponseEntity<Produto> getById(int id){
        Optional<Produto> produto = produtoService.getById(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/api/produto/update/{id}")
    public ResponseEntity<Produto> update(@PathVariable int id, @RequestBody Produto produto){
        Optional<Produto> produtoOptional = produtoService.getById(id);
        if(produtoOptional.isPresent()){
            produto.setId(id);
            Produto upProduto = produtoService.save(produto);
            return ResponseEntity.ok(upProduto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/api/produto/{id}")
    public ResponseEntity<Produto> deleteById(@PathVariable int id){
        if(produtoService.getById(id).isPresent()){
            produtoService.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
