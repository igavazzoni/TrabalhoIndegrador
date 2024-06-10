package com.example.vendasapi.service;

import com.example.vendasapi.model.Produto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;
import com.example.vendasapi.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
@Tag(name = "Produto Service", description = "Service da classe Produto")
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAll() { return this.produtoRepository.findAll(); }

    public Produto save(Produto produto) { return this.produtoRepository.save(produto); }

    public void deleteById(int id) { this.produtoRepository.deleteById(id); }

    public Optional<Produto> getById(int id) { return this.produtoRepository.findById(id); }
}
