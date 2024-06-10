package com.example.vendasapi.service;

import com.example.vendasapi.model.Venda;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;
import com.example.vendasapi.repository.VendaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Tag(name = "Venda Service", description = "Service da classe Venda")
public class VendaService {
    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> getAll(){return this.vendaRepository.findAll();}

    public Venda save(Venda venda){return vendaRepository.save(venda);}

    public void deleteById(int id){vendaRepository.deleteById(id);}

    public Optional<Venda> getById(int id){return vendaRepository.findById(id);}
}
